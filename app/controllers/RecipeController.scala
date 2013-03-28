package controllers

import play.api.data._
import play.api.data.Forms._
import play.api.mvc._
import play.api.templates._
import models._
import controllers.Application._

object RecipeController extends Controller {

	val searchForm: Form[RecipeFilter] = Form(
		mapping(
			"name" -> text,
			"tag" -> text,
			"rating" -> number(min = 0, max = 5),
			"ingredient" -> text,
			"sorting" -> number,
			"onlyMyRecipes" -> boolean,
			"userId" -> longNumber
		)(RecipeFilter.apply)(RecipeFilter.unapply)
	)

	private def findRecipes(filter: RecipeFilter) = {
		val userId = if (filter.onlyMyRecipes) filter.userId else 0
		Recipe.find(name = filter.name, tag = filter.tag, rating = filter.rating, ingredient = filter.ingredient, sorting = filter.sorting, userId = userId)
	}

	def showRecipes(html: (List[Recipe], Form[RecipeFilter], Map[String, String]) => Html) = Authenticated { implicit request =>
		val defaultFilter = RecipeFilter("", "", 0, "", 2, false, request.user.id)
		Ok(html(findRecipes(defaultFilter), searchForm.fill(defaultFilter), tagOptions(request.user.id)))
	} { implicit request =>
		val defaultFilter = RecipeFilter("", "", 0, "", 2, false, 0)
		Ok(html(findRecipes(defaultFilter), searchForm.fill(defaultFilter), tagOptions(0)))
	}

	def showRecipesQuery(html: (List[Recipe], Form[RecipeFilter], Map[String, String]) => Html) = Authenticated { implicit request =>
		searchForm.bindFromRequest.fold(
			errors => BadRequest(html(Recipe.all, errors, tagOptions(request.user.id))),
			filter => Ok(html(findRecipes(filter), searchForm.fill(filter), tagOptions(request.user.id)))
		)
	} { implicit request =>
		searchForm.bindFromRequest.fold(
			errors => BadRequest(html(Recipe.all, errors, tagOptions(0))),
			filter => Ok(html(findRecipes(filter), searchForm.fill(filter), tagOptions(0)))
		)
	}

	def recipes = showRecipes((recipes, form, tags) =>
		views.html.recipe_list(recipes, form, tags))

	def recipesQuery = showRecipesQuery((recipes, form, tags) =>
		views.html.recipe_list(recipes, form, tags))

	def recipe(recipeId: Long, page: String) = Action { implicit request =>
		val recipe = Recipe.toDto(Recipe.findById(recipeId))
		var ingredients = Ingredient.findByRecipe(recipeId)
		var preparationSteps = PreparationStep.findByRecipe(recipeId)

		page match {
			case "all" => Ok(views.html.recipe_view(recipe, ingredients, preparationSteps))
			case "info" => Ok(views.html.recipe_view_info(recipe))
			case "ingredients" => Ok(views.html.recipe_view_ingredients(recipe.id, ingredients))
			case p if (p.startsWith("step=")) => {
				val preparationStep = p.substring(p.indexOf("=") + 1).toInt
				Ok(views.html.recipe_view_preparation(recipe.id, preparationStep, preparationSteps))
			}
		}
	}

	def tagOptions(userId: Long) =
		Tag.findByUser(userId).map(tag => tag.id.toString -> tag.name).toMap

	def copyRecipe =
		showRecipes((recipes, form, tags) =>
			views.html.copy_recipe(recipes, form, tags))

	def copyRecipeQuery = showRecipesQuery((recipes, form, tags) =>
		views.html.copy_recipe(recipes, form, tags))

	def copyRecipeToUser(recipeId: Long) = AuthenticatedRequired { implicit request =>
		val recipe = Recipe.findById(recipeId)
		val copiedRecipeId = Recipe.create(recipe.name, recipe.rating, recipe.imageRef, recipe.source, request.user.id)
		Ingredient.findByRecipe(recipe.id) map (ingredient =>
			Ingredient.create(copiedRecipeId, ingredient.amount, ingredient.unit, ingredient.name)
		)
		PreparationStep.findByRecipe(recipe.id) map (preparationStep =>
			PreparationStep.create(copiedRecipeId, preparationStep.step, preparationStep.description, preparationStep.imageRef)
		)
		Redirect(routes.RecipeController.recipes)
	}

}