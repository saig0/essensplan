
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import play.api.i18n._
import play.api.mvc._
import play.api.data._
import views.html._
/**/
object recipe_list extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[List[Recipe],Form[RecipeFilter],Map[String, String],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(recipes: List[Recipe], searchForm: Form[RecipeFilter], tagOptions: Map[String, String]):play.api.templates.Html = {
        _display_ {import helper._

import tags._


Seq[Any](format.raw/*1.90*/("""

"""),format.raw/*5.1*/("""

"""),_display_(Seq[Any](/*7.2*/main("Rezepte")/*7.17*/ {_display_(Seq[Any](format.raw/*7.19*/("""
	
	"""),_display_(Seq[Any](/*9.3*/recipe_list_view(recipes, searchForm, tagOptions, routes.RecipeController.recipesQuery, (recipe: Recipe) => {
		var l = List[Html]().toBuffer
		l += form(routes.RecipeController.recipe(recipe.id, "all")) { Html("""
						<input type='submit' value='öffnen' />
						""")}
		l+=	form(routes.RecipeCreator.editRecipe(recipe.id)) { Html("""
						<input type='submit' value='bearbeiten' />
					""")}
		l+=	form(routes.RecipeCreator.removeRecipe(recipe.id)) { Html("""
						<input type='submit' value='entfernen' />
					""")}
		l.toList
	})("Rezepte"))),format.raw/*21.15*/("""
	
	<table>
		<tr>
			<td>
				"""),_display_(Seq[Any](/*26.6*/form(routes.RecipeCreator.newRecipe)/*26.42*/ {_display_(Seq[Any](format.raw/*26.44*/("""
					<input type="submit" value="neues Rezept" />
				""")))})),format.raw/*28.6*/("""	
			</td>
		</tr>
		<tr>
			<td>
				"""),_display_(Seq[Any](/*33.6*/form(routes.RecipeImport.importRecipe)/*33.44*/ {_display_(Seq[Any](format.raw/*33.46*/("""
					<input type="submit" value="Rezept importieren" />
				""")))})),format.raw/*35.6*/("""
			</td>
		</tr>
		<tr>
			<td>
				"""),_display_(Seq[Any](/*40.6*/form(routes.RecipeController.copyRecipe)/*40.46*/ {_display_(Seq[Any](format.raw/*40.48*/("""
					<input type="submit" value="Rezept kopieren" />
				""")))})),format.raw/*42.6*/("""
			</td>
		</tr>
		<tr>
			<td>
				"""),_display_(Seq[Any](/*47.6*/form(routes.TagController.tags)/*47.37*/ {_display_(Seq[Any](format.raw/*47.39*/("""
					<input type="submit" value="Stichwörter verwalten" />
				""")))})),format.raw/*49.6*/("""
			</td>
		</tr>
	</table>
""")))})))}
    }
    
    def render(recipes:List[Recipe],searchForm:Form[RecipeFilter],tagOptions:Map[String, String]) = apply(recipes,searchForm,tagOptions)
    
    def f:((List[Recipe],Form[RecipeFilter],Map[String, String]) => play.api.templates.Html) = (recipes,searchForm,tagOptions) => apply(recipes,searchForm,tagOptions)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Mar 28 12:14:26 CET 2013
                    SOURCE: E:/Eigene Dateien/workspace-scala/essensplan/app/views/recipe_list.scala.html
                    HASH: 93dbf27492751713300d2737d5871fbd5a7fd50b
                    MATRIX: 556->1|752->89|780->123|817->126|840->141|879->143|918->148|1490->698|1557->730|1602->766|1642->768|1729->824|1803->863|1850->901|1890->903|1983->965|2056->1003|2105->1043|2145->1045|2235->1104|2308->1142|2348->1173|2388->1175|2484->1240
                    LINES: 19->1|25->1|27->5|29->7|29->7|29->7|31->9|43->21|48->26|48->26|48->26|50->28|55->33|55->33|55->33|57->35|62->40|62->40|62->40|64->42|69->47|69->47|69->47|71->49
                    -- GENERATED --
                */
            