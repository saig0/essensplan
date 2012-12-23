package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import models._
import models.Essen._

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
	
	def recipes =  Action { implicit request =>
		searchForm.bindFromRequest.fold (
			errors => BadRequest(views.html.recipe_list(Recipe.all, errors)),
			RecipeFilter => {
				val recipes = Recipe.find(name = RecipeFilter.name, rating = RecipeFilter.rating, ingredient = RecipeFilter.ingredient, sorting = RecipeFilter.sorting)
				Ok(views.html.recipe_list(recipes, searchForm.fill(RecipeFilter)))
			}
	)}
	
	def newRecipe = Action {
		Ok(views.html.recipe_new(recipeForm))
	}
	
	def editRecipe(recipeId: Long) = Action {
		val recipe = Recipe.findById(recipeId)
		val filledRecipeForm = recipeForm.fill(recipe)
		Ok(views.html.recipe_new(filledRecipeForm, recipeId))
	}
	
	val searchForm : Form[RecipeFilter] = Form (
		mapping (
			"name"		-> text,			
			"rating"	-> number(min=0, max=5),
			"ingredient"-> text,
			"sorting"	-> number
		)((name, rating, ingredient, sorting) => RecipeFilter(name, rating, ingredient, sorting))
		 ((RecipeFilter: RecipeFilter) => Some((RecipeFilter.name, RecipeFilter.rating, RecipeFilter.ingredient, RecipeFilter.sorting)))
	)
	
	val recipeForm : Form[Recipe] = Form (
		mapping (
			"name"		-> nonEmptyText,
			"rating"	-> number(min=0, max=5),	
			"imageRef"	-> text,
			"tags"		-> text
		)((name, rating, image, tags) => Recipe(0, name, rating, image, tags))
		 ((recipe: Recipe) => Some((recipe.name, recipe.rating, recipe.imageRef, recipe.tags)))
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
			errors => BadRequest(views.html.recipe_new(errors)),
			recipe => {
				val id = Recipe.create(recipe.name, recipe.rating, recipe.imageRef, recipe.tags)
				val r = new Recipe(id, recipe.name, recipe.rating, recipe.imageRef, recipe.tags)
				Redirect(routes.Application.recipeIngredients(r.id))
			}
	)}
	
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
		val recipe = Recipe.findById(recipeId)		
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
			errors => BadRequest(views.html.recipe_new(errors)),
			recipe => {
				val r = new Recipe(recipeId, recipe.name, recipe.rating, recipe.imageRef, recipe.tags)				
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
}