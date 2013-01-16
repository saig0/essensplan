package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.templates._
import models._
import models.Essen._
import java.util.Date
import java.text.SimpleDateFormat

object Application extends Controller {
      
  def essen = Action {
	Ok(views.html.index(Essen.alle, essenForm))
  }
  
  def neuesEssen = Action { implicit request =>
	essenForm.bindFromRequest.fold (
		errors => BadRequest(views.html.index(Essen.alle, errors)),
		e => {
			Essen.neu(e.name, e.verweis, e.tag)
			Redirect(routes.Application.essen)
		}
	)
  }
  
  def entferneEssen(name: String) =  Action {
	Essen.entfernen(name)
	Redirect(routes.Application.essen)
  }
  
  val essenForm: Form[Essen] = Form (
	mapping (
		"name" -> nonEmptyText,
		"verweis" -> nonEmptyText,
		"tag" -> nonEmptyText
		)(Essen.apply)(Essen.unapply)
	)
	
	// ---------------------------------------------------
	
	private def findRecipes(filter: RecipeFilter) = 
		Recipe.find(name = filter.name, tag = filter.tag, rating = filter.rating, ingredient = filter.ingredient, sorting = filter.sorting)
	
	private def showRecipes(html: (List[Recipe], Form[RecipeFilter], Map[String, String]) => Html) = Action { request =>
		val defaultFilter = RecipeFilter("", "", 0, "", 2)
		Ok(html(findRecipes(defaultFilter), searchForm.fill(defaultFilter), tagOptions))
	}
	
	private def showRecipesQuery(html: (List[Recipe], Form[RecipeFilter], Map[String, String]) => Html) = Action { implicit request =>
		searchForm.bindFromRequest.fold (
			errors => BadRequest(html(Recipe.all, errors, tagOptions)),
			filter => Ok(html(findRecipes(filter), searchForm.fill(filter), tagOptions))	
	)}
		
	def recipes = showRecipes((recipes, form, tags) => views.html.recipe_list(recipes, form, tags))
	
	def recipesQuery =  showRecipesQuery((recipes, form, tags) => views.html.recipe_list(recipes, form, tags))
	
	private def showNewRecipe(form: Form[RecipeDTO], recipeId: Long = 0) = Action {
		Ok(views.html.recipe_new(form, tagOptions, recipeId))
	}
	
	def newRecipe = showNewRecipe(recipeForm)
	
	def editRecipe(recipeId: Long) = {
		val recipe = Recipe.toDto(Recipe.findById(recipeId))
		val filledRecipeForm = recipeForm.fill(recipe)
		showNewRecipe(filledRecipeForm, recipeId)
	}
	
	val searchForm : Form[RecipeFilter] = Form (
		mapping (
			"name"		-> text,
			"tag"		-> text,
			"rating"	-> number(min=0, max=5),
			"ingredient"-> text,
			"sorting"	-> number
		)((name, tag, rating, ingredient, sorting) => RecipeFilter(name, tag, rating, ingredient, sorting))
		 ((recipeFilter: RecipeFilter) => Some((recipeFilter.name, recipeFilter.tag, recipeFilter.rating, recipeFilter.ingredient, recipeFilter.sorting)))
	)
	
	val recipeForm : Form[RecipeDTO] = Form (
		mapping (
			"name"		-> nonEmptyText,
			"rating"	-> number(min=0, max=5),	
			"imageRef"	-> text,
			"tags"		-> list(text)
		)((name, rating, image, tags) => RecipeDTO(0, name, rating, image, tags.map(tag => new Tag(tag.toInt, ""))))
		 ((recipe: RecipeDTO) => Some((recipe.name, recipe.rating, recipe.imageRef, recipe.tags.map(_.id.toString))))
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
	
	def removeRecipe(recipeId: Long) = Action { 
		Recipe.delete(recipeId)
		Redirect(routes.Application.recipes)
	}
	
	def createRecipe = Action { implicit request =>		
		recipeForm.bindFromRequest.fold (
			errors => {
				BadRequest(views.html.recipe_new(errors, tagOptions))
			},
			recipe => {
				val id = Recipe.create(recipe.name, recipe.rating, recipe.imageRef)				
				val tags = extractTags(request.body.asFormUrlEncoded)				
				tags.map(tagId => RecipeTag.create(id, tagId))
				val r = new Recipe(id, recipe.name, recipe.rating, recipe.imageRef)
				Redirect(routes.Application.recipeIngredients(r.id))
			}
	)}
	
	private def tagOptions = Tag.all.map(tag => tag.id.toString -> tag.name).toMap
	
	private def extractTags(url: Option[Map[String, Seq[String]]]): List[Long] = url match {
		case None			=> List[Long]()
		case Some(params) 	=> params.get("tags") match {
						case None		=> List[Long]()
						case Some(tags)	=> tags.map(_.toLong).toList
		}			
	}
	
	def recipeIngredients(recipeId: Long) = Action {
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
	
	def removeRecipeIngredient(recipeId:Long, ingredientId: Long) = Action {
		Ingredient.delete(ingredientId)
		Redirect(routes.Application.recipeIngredients(recipeId))
	}
		 
	def recipe(recipeId: Long, page: String) = Action {
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
	
	def updateRecipe(recipeId: Long) = Action { implicit request =>
		recipeForm.bindFromRequest.fold (
			errors => {
				BadRequest(views.html.recipe_new(errors, tagOptions))
			},
			recipe => {
				val r = new Recipe(recipeId, recipe.name, recipe.rating, recipe.imageRef)
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
	
	def recipePreparation(recipeId: Long) = Action {
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
	
	def removePreparationStep(recipeId: Long, preparationStepId: Long) = Action {
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
	
	private def findMeals(filter: MealFilter) = Meal.findByDate(from = filter.from, to = filter.to).map(meal => Meal.toDTO(meal)) 
	
	def meals =  Action { 
		val DAY = 1000*60*60*24
		val sdf = new SimpleDateFormat("yyyy-MM-dd");      
		val today = sdf.parse(sdf.format(new Date()));
		val defaultFilter = MealFilter(today, new Date(today.getTime() + DAY * 7))
		Ok(views.html.meal_list(findMeals(defaultFilter), mealForm.fill(defaultFilter)))
	}
	
	def mealsQuery =  Action { implicit request =>
		mealForm.bindFromRequest.fold (
			errors => BadRequest(views.html.meal_list(List[MealDTO](), errors)),
			mealFilter => {
				Ok(views.html.meal_list(findMeals(mealFilter), mealForm.fill(mealFilter)))
			}
	)}
	
	def mealsNewRecipe = showRecipes((recipes, form, tags) => views.html.meal_new_recipe(recipes, form, tags))
	
	def mealsNewRecipeQuery = showRecipesQuery((recipes, form, tags) => 		views.html.meal_new_recipe(recipes, form, tags))	
	
	def mealsNewDay(recipeId: Long) = Action {
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
	
	def mealsNew(recipeId: Long) = Action { implicit request =>
		newMealForm.bindFromRequest.fold (
			errors => BadRequest(views.html.meal_new_day(Recipe.findById(recipeId), errors)),
			filter => {
				Meal.create(recipeId, filter.date)			
				Redirect(routes.Application.meals)
			}
	)}
	
	def mealRemove(mealId: Long) = Action {
		Meal.delete(mealId)
		Redirect(routes.Application.meals)
	}
	
	def mealUpdate(recipeId: Long, mealId: Long) = Action { implicit request =>
		newMealForm.bindFromRequest.fold (
			errors => BadRequest(views.html.meal_new_day(Recipe.findById(recipeId), errors)),
			filter => {
				val meal = new Meal(mealId, recipeId, filter.date)
				Meal.update(meal)			
				Redirect(routes.Application.meals)
			}
	)}
	
	def mealEdit(mealId: Long) = Action {
		val meal = Meal.findById(mealId)
		val recipe = Recipe.findById(meal.recipeId)
		val form = newMealForm.fill(NewMealFilter(date = meal.date))
		Ok(views.html.meal_new_day(recipe, form, mealId))
	}
	
	def mealShoppingList(from: String, to: String) = Action { implicit request =>
		val sdf = new SimpleDateFormat("yyyy-MM-dd")    
		val fromDate = sdf.parse(from)
		val toDate = sdf.parse(to)
		val filter = MealFilter(fromDate, toDate)
		
		var ingredients = Map[(String, String), Ingredient]()
		findMeals(filter).map(meal => Ingredient.findByRecipe(meal.recipe.id)).flatten.sortWith((x,y) => x.name.compareTo(y.name) < 0).foreach( i =>
			ingredients.get((i.name, i.unit)) match {
				case None		=> ingredients+= (i.name, i.unit) -> i
				case Some(x)	=> ingredients+= (i.name, i.unit) -> i.copy(amount = i.amount + x.amount)
			}
		)
		Ok(views.html.meal_shopping_list(ingredients.values.toList))			
	}
}