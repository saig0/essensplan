package controllers

import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.libs.ws.WS
import play.api.libs.openid._
import play.api.libs.openid.Errors._
import play.api.libs.concurrent._
import models._
import scala.xml._
import controllers.AuthenticatedRequest._

object RecipeImport extends Controller with Authentication {

	val importRecipeForm: Form[String] = Form(
		"recipeId" -> nonEmptyText
	)

	def importRecipe = AuthenticatedRequired { implicit request =>
		Ok(views.html.importRecipe(importRecipeForm))
	}

	def importRecipeWithId = AuthenticatedRequired { implicit request =>
		importRecipeForm.bindFromRequest.fold(
			errors => BadRequest(views.html.importRecipe(errors)),
			recipeId => {
				val url = "http://www.chefkoch.de/rezepte/" + recipeId
				Async {
					WS.url(url).get().map { response =>
						try {
							val xml = loadFromString(response.body)
							val id = parseChefkochPage(xml, url, request.user)
							Ok(views.html.importRecipe(importRecipeForm, id))
						} catch {
							case _ =>
								Ok(views.html.importRecipe(importRecipeForm.fill(recipeId), -1))
						}
					}
				}
			}
		)
	}

	private def parseChefkochPage(xml: Node, url: String, user: User): Long = {
		val recipeName = (xml \\ "h1" filter (h1 => (h1 \ "@class").text == "page-title fn")).text

		val imageRef = ((xml \\ "img" filter (img => (img \ "@class").text == "slideshow-image")) \ "@src").text

		val rating = ((xml \\ "span" filter (span => (span \ "@class").text == "average")) \ "span" \ "@title").text.toDouble.round.toInt

		val i1 = (xml \\ "tr" filter (tr => (tr \ "@class").text == "ingredient")) \ "td" filter (td => (td \ "@class").text == "amount") map (t =>
			extactIngredient(t.text.trim))

		val i2 = (xml \\ "tr" filter (tr => (tr \ "@class").text == "ingredient")) \ "td" filter (td => (td \ "@class").text == "name") map (_.text.trim)

		val ingredients = for {
			x <- 0 to i1.size - 1
		} yield i1(x) -> i2(x)

		val descriptions = (xml \\ "div" filter (div => (div \ "@class").text == "instructions")).text.trim

		val recipeId = Recipe.create(recipeName, rating, imageRef, url, user.id)

		ingredients map (ingredient =>
			ingredient match {
				case ((amount, unit), name) =>
					Ingredient.create(recipeId, amount, unit, name)
			}
		)

		// einfache Lösung
		PreparationStep.create(recipeId, 1, descriptions, "")
		/* Trennung teilweise nicht sinnvoll
				var step = 1
				for(description <- descriptions.split("\\.")){
					val desc = if(description.length < 255) description else description.substring(0,255) 
					PreparationStep.create(recipeId, step, desc, "")
					step += 1
				}  */

		return recipeId;
	}

	private def extactIngredient(s: String): (Int, String) = {
		val regex = """(\d{1,4})[^A-Za-z]*([A-ZÄÖÜa-zäöü]*)""".r
		s match {
			case regex(d, w) => (d.toInt, w)
			case _ => (0, "")
		}
	}

	private def loadFromUrl(url: String): Node =
		load(new InputSource(new java.net.URL(url).openConnection().getInputStream()))

	private def loadFromString(html: String): Node =
		load(new org.xml.sax.InputSource(new java.io.StringReader(html)))

	private def load(input: InputSource): Node = {
		import org.ccil.cowan.tagsoup.Parser
		import org.ccil.cowan.tagsoup.XMLWriter
		import java.io.StringWriter
		import org.xml.sax.InputSource

		val parser = new Parser()
		val writer = new StringWriter()

		parser.setContentHandler(new XMLWriter(writer))
		parser.parse(input)

		scala.xml.XML.loadString(writer.toString())
	}
}