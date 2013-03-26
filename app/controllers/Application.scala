package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.templates._
import play.api.libs.ws.WS
import play.api.libs.openid._
import play.api.libs.openid.Errors._
import play.api.libs.concurrent._
import models._
import java.util.Date
import java.text.SimpleDateFormat
import scala.xml._ 
	
object Application extends Controller {
      
   def index = Authenticated { implicit request =>
		Redirect(routes.Application.meals) } 
	{ implicit request =>
		Redirect(routes.Application.recipes)
	}

	// -----
	
	private def findRecipes(filter: RecipeFilter) = {
		val userId = if(filter.onlyMyRecipes) filter.userId else 0
		Recipe.find(name = filter.name, tag = filter.tag, rating = filter.rating, ingredient = filter.ingredient, sorting = filter.sorting, userId = userId) 
	}
	
	private def showRecipes(html: (List[Recipe], Form[RecipeFilter], Map[String, String]) => Html) =  Authenticated { implicit request =>
		val defaultFilter = RecipeFilter("", "", 0, "", 2, false, request.user.id)
		Ok(html(findRecipes(defaultFilter), searchForm.fill(defaultFilter), tagOptions(request.user.id))) } 
	{ implicit request =>
		val defaultFilter = RecipeFilter("", "", 0, "", 2, false, 0)
		Ok(html(findRecipes(defaultFilter), searchForm.fill(defaultFilter), tagOptions(0))) } 	
	
	private def showRecipesQuery(html: (List[Recipe], Form[RecipeFilter], Map[String, String]) => Html) = Authenticated { implicit request =>
		searchForm.bindFromRequest.fold (
			errors => BadRequest(html(Recipe.all, errors, tagOptions(request.user.id))),
			filter => Ok(html(findRecipes(filter), searchForm.fill(filter), tagOptions(request.user.id)))	
	)}{ implicit request =>
		searchForm.bindFromRequest.fold (
			errors => BadRequest(html(Recipe.all, errors, tagOptions(0))),
			filter => Ok(html(findRecipes(filter), searchForm.fill(filter), tagOptions(0)))	
	)}
		
	def recipes = showRecipes((recipes, form, tags) => 
		views.html.recipe_list(recipes, form, tags))
	
	def recipesQuery =  showRecipesQuery((recipes, form, tags) => 
		views.html.recipe_list(recipes, form, tags))
	
	private def showNewRecipe(form: Form[RecipeDTO], recipeId: Long = 0) = AuthenticatedRequired { implicit request =>
		Ok(views.html.recipe_new(form, tagOptions(request.user.id), recipeId))
	}
	
	def newRecipe = showNewRecipe(recipeForm)
	
	def editRecipe(recipeId: Long) = AuthenticatedRequired { implicit request =>
		val r = Recipe.findById(recipeId)
		if(r.userId == request.user.id){		
			val recipe = Recipe.toDto(r)
			val filledRecipeForm = recipeForm.fill(recipe)
			Ok(views.html.recipe_new(filledRecipeForm, tagOptions(request.user.id), recipeId))
		} else {
			Ok(views.html.index("Nur der Author darf das Rezept ändern!"))
		}
	}
	
	val searchForm : Form[RecipeFilter] = Form (
		mapping (
			"name"		-> text,
			"tag"		-> text,
			"rating"	-> number(min=0, max=5),
			"ingredient"-> text,
			"sorting"	-> number,
			"onlyMyRecipes" -> boolean,
			"userId"	-> longNumber
		)(RecipeFilter.apply)(RecipeFilter.unapply)
	)
	
	val recipeForm : Form[RecipeDTO] = Form (
		mapping (
			"name"		-> nonEmptyText,
			"rating"	-> number(min=0, max=5),	
			"imageRef"	-> text,
			"source"	-> text,
			"tags"		-> list(text)
		)((name, rating, image, source, tags) => RecipeDTO(0, name, rating, image, source, tags.map(tag => new Tag(tag.toInt, "", 0))))
		 ((recipe: RecipeDTO) => Some((recipe.name, recipe.rating, recipe.imageRef, recipe.source,  recipe.tags.map(_.id.toString))))
	)
	
	val ingredientForm : Form[Ingredient] = Form (
		mapping (
			"amount"	-> number(min=0),
			"unit"		-> nonEmptyText,
			"name"		-> nonEmptyText
		)((amount, unit, name) => Ingredient(0, 0, amount, unit, name))
		 ((ingredient: Ingredient) => Some((ingredient.amount, ingredient.unit, ingredient.name)))
	)
	
	val preparationStepForm : Form[PreparationStep] = Form (
		mapping (
			"step"			-> number(min=1),
			"description"	-> nonEmptyText,
			"imageRef"		-> text
		)((step, description, imageRef) => PreparationStep(0, 0, step, description, imageRef))
		 ((preparationStep: PreparationStep) => Some((preparationStep.step, preparationStep.description, preparationStep.imageRef)))
	)
	
	def removeRecipe(recipeId: Long) = AuthenticatedRequired { implicit request =>
		val r = Recipe.findById(recipeId)
		if(r.userId == request.user.id){		
			Recipe.delete(recipeId)
			Redirect(routes.Application.recipes)
		} else {
			Ok(views.html.index("Nur der Author darf das Rezept löschen!"))
		}		
	}
	
	def createRecipe = AuthenticatedRequired { implicit request =>		
		recipeForm.bindFromRequest.fold (
			errors => {
				BadRequest(views.html.recipe_new(errors, tagOptions(request.user.id)))
			},
			recipe => {
				val id = Recipe.create(recipe.name, recipe.rating, recipe.imageRef, recipe.source, request.user.id)				
				val tags = extractTags(request.body.asFormUrlEncoded)				
				tags.map(tagId => RecipeTag.create(id, tagId))
				val r = new Recipe(id, recipe.name, recipe.rating, recipe.imageRef, recipe.source, request.user.id)
				Redirect(routes.Application.recipeIngredients(r.id))
			}
	)}
	
	private def tagOptions(userId: Long) = 
		Tag.findByUser(userId).map(tag => tag.id.toString -> tag.name).toMap
	
	private def extractTags(url: Option[Map[String, Seq[String]]]): List[Long] = url match {
		case None			=> List[Long]()
		case Some(params) 	=> params.get("tags") match {
						case None		=> List[Long]()
						case Some(tags)	=> tags.map(_.toLong).toList
		}			
	}
	
	def recipeIngredients(recipeId: Long) = Action { implicit request =>
		val recipe = Recipe.findById(recipeId)		
		var ingredients = Ingredient.findByRecipe(recipeId)
		Ok(views.html.recipe_new_ingredients(recipe, ingredients, ingredientForm))
	}
	
	def addRecipeIngredient(recipeId: Long) = Action { implicit request =>
		val recipe = Recipe.findById(recipeId)		
		var ingredients = Ingredient.findByRecipe(recipeId)
		ingredientForm.bindFromRequest.fold (
			errors => BadRequest(views.html.recipe_new_ingredients(recipe, ingredients,errors)),
			ingredient => {
				val id = Ingredient.create(recipeId, ingredient.amount, ingredient.unit, ingredient.name)
				val i = new Ingredient(id,recipeId, ingredient.amount, ingredient.unit, ingredient.name)
				Ok(views.html.recipe_new_ingredients(recipe, ingredients ++ (i :: Nil), ingredientForm))
			}
	)}	
	
	def removeRecipeIngredient(recipeId:Long, ingredientId: Long) = Action { implicit request =>
		Ingredient.delete(ingredientId)
		Redirect(routes.Application.recipeIngredients(recipeId))
	}
		 
	def recipe(recipeId: Long, page: String) = Action { implicit request =>
		val recipe = Recipe.toDto(Recipe.findById(recipeId))		
		var ingredients = Ingredient.findByRecipe(recipeId)
		var preparationSteps = PreparationStep.findByRecipe(recipeId)
		
		page match {
			case "all"							=> Ok(views.html.recipe_view(recipe, ingredients, preparationSteps))
			case "info"							=> Ok(views.html.recipe_view_info(recipe))
			case "ingredients"					=> Ok(views.html.recipe_view_ingredients(recipe.id, ingredients))
			case p	if(p.startsWith("step="))	=> {
				val preparationStep = p.substring(p.indexOf("=") + 1).toInt
				Ok(views.html.recipe_view_preparation(recipe.id, preparationStep, preparationSteps))
			}
		}
	}
	
	def updateRecipe(recipeId: Long) = AuthenticatedRequired { implicit request =>
		recipeForm.bindFromRequest.fold (
			errors => {
				BadRequest(views.html.recipe_new(errors, tagOptions(request.user.id)))
			},
			recipe => {
				val r = new Recipe(recipeId, recipe.name, recipe.rating, recipe.imageRef, recipe.source, 0)
				val tags = extractTags(request.body.asFormUrlEncoded)
				RecipeTag.findByRecipe(recipeId).map(recipeTag => 
					if(!tags.contains(recipeTag.tagId)) {
						RecipeTag.delete(recipeTag.id)
					}
				)				
				tags.diff(RecipeTag.findByRecipe(recipeId).map(_.tagId)).map(tagId => RecipeTag.create(recipeId, tagId))
				Recipe.update(r)
				Redirect(routes.Application.recipeIngredients(recipeId)) 
			}
	)}
	
	def recipePreparation(recipeId: Long) = Action { implicit request =>
		val recipe = Recipe.findById(recipeId)		
		var preparationSteps = PreparationStep.findByRecipe(recipeId)
		Ok(views.html.recipe_new_preparation(recipe, preparationSteps, preparationStepForm))
	}
	
	def addPreparationStep(recipeId: Long) = Action { implicit request =>
		val recipe = Recipe.findById(recipeId)		
		var preparationSteps = PreparationStep.findByRecipe(recipeId)
		preparationStepForm.bindFromRequest.fold (
			errors => BadRequest(views.html.recipe_new_preparation(recipe, preparationSteps,errors)),
			preparationStep => {
				val id = PreparationStep.create(recipeId, preparationStep.step, preparationStep.description, preparationStep.imageRef)
				val p = new PreparationStep(id,recipeId, preparationStep.step, preparationStep.description, preparationStep.imageRef)
				Ok(views.html.recipe_new_preparation(recipe, preparationSteps ++ (p :: Nil), preparationStepForm))
			}
	)}	
	
	def removePreparationStep(recipeId: Long, preparationStepId: Long) = Action { implicit request =>
		PreparationStep.delete(preparationStepId)
		Redirect(routes.Application.recipePreparation(recipeId))
	}
	
	
	// ---------------------------------------------------
	
	val mealForm : Form[MealFilter] = Form (
		mapping (
			"from"		-> date,			
			"to"		-> date
		)((from, to) => MealFilter(from, to))
		 ((mealFilter: MealFilter) => Some((mealFilter.from, mealFilter.to)))
	)
	
	private def findMeals(filter: MealFilter, userId: Long) = 
		Meal.findByDate(from = filter.from, to = filter.to, userId).map(meal => Meal.toDTO(meal)) 
	
	def meals = AuthenticatedRequired { implicit request =>
		val DAY = 1000*60*60*24
		val sdf = new SimpleDateFormat("yyyy-MM-dd");      
		val today = sdf.parse(sdf.format(new Date()));
		val defaultFilter = MealFilter(today, new Date(today.getTime() + DAY * 7))
		Ok(views.html.meal_list(findMeals(defaultFilter, request.user.id), mealForm.fill(defaultFilter)))
	}
	
	def mealsQuery = AuthenticatedRequired { implicit request =>
		mealForm.bindFromRequest.fold (
			errors => BadRequest(views.html.meal_list(List[MealDTO](), errors)),
			mealFilter => {
				Ok(views.html.meal_list(findMeals(mealFilter, request.user.id), mealForm.fill(mealFilter)))
			}
	)}
	
	def mealsNewRecipe = showRecipes((recipes, form, tags) => 
		views.html.meal_new_recipe(recipes, form, tags))
	
	def mealsNewRecipeQuery = showRecipesQuery((recipes, form, tags) => 		views.html.meal_new_recipe(recipes, form, tags))	
	
	def mealsNewDay(recipeId: Long) = Action { implicit request =>
		val recipe = Recipe.findById(recipeId)
		val form = newMealForm.fill(NewMealFilter(date = new Date()))
		Ok(views.html.meal_new_day(recipe, form))
	}
	
	val newMealForm : Form[NewMealFilter] = Form (
		mapping (				
			"date"		-> date
		)((date) => NewMealFilter(date))
		 ((filter: NewMealFilter) => Some((filter.date)))
	)
	
	def mealsNew(recipeId: Long) = AuthenticatedRequired { implicit request =>
		newMealForm.bindFromRequest.fold (
			errors => BadRequest(views.html.meal_new_day(Recipe.findById(recipeId), errors)),
			filter => {
				Meal.create(recipeId, filter.date, request.user.id)			
				Redirect(routes.Application.meals)
			}
	)}
	
	def mealRemove(mealId: Long) = Action { implicit request =>
		Meal.delete(mealId)
		Redirect(routes.Application.meals)
	}
	
	def mealUpdate(recipeId: Long, mealId: Long) = Action { implicit request =>
		newMealForm.bindFromRequest.fold (
			errors => BadRequest(views.html.meal_new_day(Recipe.findById(recipeId), errors)),
			filter => {
				val meal = new Meal(mealId, recipeId, filter.date, 0)
				Meal.update(meal)			
				Redirect(routes.Application.meals)
			}
	)}
	
	def mealEdit(mealId: Long) = Action { implicit request =>
		val meal = Meal.findById(mealId)
		val recipe = Recipe.findById(meal.recipeId)
		val form = newMealForm.fill(NewMealFilter(date = meal.date))
		Ok(views.html.meal_new_day(recipe, form, mealId))
	}
	
	def mealShoppingList(from: String, to: String) = AuthenticatedRequired { implicit request =>
		val sdf = new SimpleDateFormat("dd.MM.yyyy")    
		val fromDate = sdf.parse(from)
		val toDate = sdf.parse(to)
		val filter = MealFilter(fromDate, toDate)
		
		var ingredients = Map[(String, String), Ingredient]()
		findMeals(filter, request.user.id).map(meal => Ingredient.findByRecipe(meal.recipe.id)).flatten.sortWith((x,y) => x.name.compareTo(y.name) < 0).foreach( i =>
			ingredients.get((i.name, i.unit)) match {
				case None		=> ingredients+= (i.name, i.unit) -> i
				case Some(x)	=> ingredients+= (i.name, i.unit) -> i.copy(amount = i.amount + x.amount)
			}
		)
		Ok(views.html.meal_shopping_list(ingredients.values.toList))			
	}
				
	val mealProposalForm = Form (
		mapping (
			"proposals"	-> list( 
				mapping (
					"recipeId"	-> longNumber,
					"checked"	-> boolean
				)(MealProposal.apply)(MealProposal.unapply)
			)
		)(MealProposals.apply)(MealProposals.unapply)
	)
	
	def mealProposal = Action { implicit request =>
		val proposals = MealProposals(List(MealProposal(1), MealProposal(2)))
		Ok(views.html.meal_proposal(mealProposalForm.fill(proposals)))
	}
	
	// ----------------
	
	def tags = AuthenticatedRequired { implicit request =>
		Ok(views.html.tag_list(Tag.findByUser(request.user.id), tagForm))
	}
	
	val tagForm : Form[Tag] = Form (
		mapping (				
			"name"		-> nonEmptyText
		)((name) => Tag(0, name, 0))
		 ((tag: Tag) => Some((tag.name)))
	)
	
	def tagNew = AuthenticatedRequired { implicit request =>
		tagForm.bindFromRequest.fold (
			errors => BadRequest(views.html.tag_list(Tag.findByUser(request.user.id), errors)),
			filter => {
				Tag.create(filter.name, request.user.id)
				Redirect(routes.Application.tags)
			}
	)}
	
	def tagRemove(tagId: Long) = AuthenticatedRequired { implicit request =>
		Tag.delete(tagId)
		Redirect(routes.Application.tags)
	}
	
	def tagEdit(tagId: Long) = AuthenticatedRequired { implicit request =>
		Ok(views.html.tag_list(Tag.findByUser(request.user.id), tagForm.fill(Tag.findById(tagId)), tagId))
	}
	
	def tagUpdate(tagId: Long) = AuthenticatedRequired { implicit request =>
		tagForm.bindFromRequest.fold (
			errors => BadRequest(views.html.tag_list(Tag.findByUser(request.user.id), errors)),
			filter => {
				val tag = Tag.findById(tagId).copy(name = filter.name)
				Tag.update(tag)
				Redirect(routes.Application.tags)
			}
	)}
	
	// --------
	
	def importRecipe = AuthenticatedRequired { implicit request =>
		Ok(views.html.importRecipe(importRecipeForm))
	}
	
	val importRecipeForm : Form[String] = Form (
		"recipeId"		-> nonEmptyText
	)
	
	def importRecipeWithId = AuthenticatedRequired { implicit request =>
		importRecipeForm.bindFromRequest.fold (
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
	
	def parseChefkochPage(xml: Node, url: String, user: User): Long = {			
				val recipeName = ( xml \\ "h1" filter ( h1 => ( h1 \ "@class" ).text == "page-title fn" ) ).text
			 	
				val imageRef = (( xml \\ "img" filter ( img => ( img \ "@class" ).text == "slideshow-image" ) ) \ "@src").text
								
				val rating = (( xml \\ "span" filter ( span => ( span \ "@class" ).text == "average" ) ) \ "span" \ "@title" ).text.toDouble.round.toInt 
				
				val i1 = ( xml \\ "tr" filter ( tr => ( tr \ "@class" ).text == "ingredient" ) ) \ "td" filter ( td => ( td \ "@class" ).text == "amount" ) map ( t =>
					extactIngrement(t.text.trim) )
								
				val i2 = ( xml \\ "tr" filter ( tr => ( tr \ "@class" ).text == "ingredient" ) ) \ "td" filter ( td => ( td \ "@class" ).text == "name" ) map ( _.text.trim ) 
				
				val ingredients = for {
						x <- 0 to i1.size -1
					} yield i1(x) -> i2(x)
				
				val descriptions = ( xml \\ "div" filter ( div => ( div \ "@class" ).text == "instructions" ) ) .text.trim
				
				val recipeId = Recipe.create(recipeName, rating, imageRef, url, user.id) 
				
				ingredients map ( ingredient => 
					ingredient match {
						case ((amount, unit),name) => 
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
	
	def extactIngrement(s: String): (Int,String) = {
		val regex = """(\d{1,4})[^A-Za-z]*([A-ZÄÖÜa-zäöü]*)""".r
		s match {
			case regex(d,w) => (d.toInt, w)
			case _ => (0,"")
		}
	}
		
	private def loadFromUrl(url:String): Node = 
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
  
  // ----------------
  
	def copyRecipe = 
		showRecipes((recipes, form, tags) => 
		views.html.copy_recipe(recipes, form, tags))
	
	def copyRecipeQuery = showRecipesQuery((recipes, form, tags) => 					
		views.html.copy_recipe(recipes, form, tags))	
	
	def copyRecipeToUser(recipeId: Long) = AuthenticatedRequired { implicit request =>
		val recipe = Recipe.findById(recipeId)
		val copiedRecipeId = Recipe.create(recipe.name, recipe.rating, recipe.imageRef, recipe.source, request.user.id)
		Ingredient.findByRecipe(recipe.id) map ( ingredient =>
			Ingredient.create(copiedRecipeId, ingredient.amount, ingredient.unit, ingredient.name)
		)
		PreparationStep.findByRecipe(recipe.id) map ( preparationStep =>
			PreparationStep.create(copiedRecipeId, preparationStep.step, preparationStep.description, preparationStep.imageRef)
		)
		Redirect(routes.Application.recipes)
	}
  
  // -----------------
  
	val openid = "www.google.com/accounts/o8/id"
  
	def login(uri: String) = Action { implicit request =>	
		val redirectUrl =  routes.Application.openIDCallback(uri.substring(1)).absoluteURL()
		AsyncResult(OpenID.redirectURL(openid, redirectUrl,
			Seq("email" -> "http://schema.openid.net/contact/email"))
			  .extend( _.value match {
				  case Redeemed(url) => Redirect(url)
				  case e: OpenIDError => Ok {"Fehler bei der Anmeldung über OpenId: " + e.message}
			  }))
	}
	
	def openIDCallback(uri: String) = Action { implicit request =>
		  AsyncResult(
			OpenID.verifiedId.extend( _.value match {
			  case Redeemed(info) => {
				val email = info.attributes("email")
				val userId = User.findByEmail(email) match {
					case Some(user)	=> user.id
					case None		=> User.create(email)
				}
				val redirectUrl = "http://" + request.host + "/" +uri
				Redirect(redirectUrl).withSession(
					session + ("user" -> userId.toString)
				)
			  }
			  case e: OpenIDError => Ok {"Fehler bei der Anmeldung über OpenId: " + e.message}
			})
		  )
	}
	
	def logout = Action { implicit request =>
		Redirect(routes.Application.index).withNewSession
	}
		
	case class AuthenticatedRequest(
	  user: User, private val request: Request[AnyContent]
	) extends WrappedRequest(request)

	def Authenticated(authRequest: AuthenticatedRequest => Result)(unauthRequest: Request[AnyContent] => Result) = {
	  Action { request =>
		request.session.get("user") match {
			case Some(userId) 	=> {
				val user = User.findById(userId.toLong)
				authRequest(AuthenticatedRequest(user, request))
			}
			case None			=> unauthRequest(request)
		}
	  }
	}
	
	def AuthenticatedRequired(authRequest: AuthenticatedRequest => Result) = 
		Authenticated(authRequest){ implicit request => 
			Ok(views.html.unauthenticated(request.uri)) 
		}
	
}