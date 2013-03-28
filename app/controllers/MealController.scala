package controllers

import play.api.data._
import play.api.data.Forms._
import play.api.mvc._
import models._
import controllers.RecipeController._
import java.util.Date
import java.text.SimpleDateFormat

object MealController extends Controller with Authentication {

	val mealForm: Form[MealFilter] = Form(
		mapping(
			"from" -> date,
			"to" -> date
		)((from, to) => MealFilter(from, to))((mealFilter: MealFilter) => Some((mealFilter.from, mealFilter.to)))
	)

	private def findMeals(filter: MealFilter, userId: Long) =
		Meal.findByDate(from = filter.from, to = filter.to, userId).map(meal => Meal.toDTO(meal))

	def meals = AuthenticatedRequired { implicit request =>
		val DAY = 1000 * 60 * 60 * 24
		val sdf = new SimpleDateFormat("yyyy-MM-dd");
		val today = sdf.parse(sdf.format(new Date()));
		val defaultFilter = MealFilter(today, new Date(today.getTime() + DAY * 7))
		Ok(views.html.meal_list(findMeals(defaultFilter, request.user.id), mealForm.fill(defaultFilter)))
	}

	def mealsQuery = AuthenticatedRequired { implicit request =>
		mealForm.bindFromRequest.fold(
			errors => BadRequest(views.html.meal_list(List[MealDTO](), errors)),
			mealFilter => {
				Ok(views.html.meal_list(findMeals(mealFilter, request.user.id), mealForm.fill(mealFilter)))
			}
		)
	}

	def mealsNewRecipe = showRecipes((recipes, form, tags) =>
		views.html.meal_new_recipe(recipes, form, tags))

	def mealsNewRecipeQuery = showRecipesQuery((recipes, form, tags) => views.html.meal_new_recipe(recipes, form, tags))

	def mealsNewDay(recipeId: Long) = Action { implicit request =>
		val recipe = Recipe.findById(recipeId)
		val form = newMealForm.fill(NewMealFilter(date = new Date()))
		Ok(views.html.meal_new_day(recipe, form))
	}

	val newMealForm: Form[NewMealFilter] = Form(
		mapping(
			"date" -> date
		)((date) => NewMealFilter(date))((filter: NewMealFilter) => Some((filter.date)))
	)

	def mealsNew(recipeId: Long) = AuthenticatedRequired { implicit request =>
		newMealForm.bindFromRequest.fold(
			errors => BadRequest(views.html.meal_new_day(Recipe.findById(recipeId), errors)),
			filter => {
				Meal.create(recipeId, filter.date, request.user.id)
				Redirect(routes.MealController.meals)
			}
		)
	}

	def mealRemove(mealId: Long) = Action { implicit request =>
		Meal.delete(mealId)
		Redirect(routes.MealController.meals)
	}

	def mealUpdate(recipeId: Long, mealId: Long) = Action { implicit request =>
		newMealForm.bindFromRequest.fold(
			errors => BadRequest(views.html.meal_new_day(Recipe.findById(recipeId), errors)),
			filter => {
				val meal = new Meal(mealId, recipeId, filter.date, 0)
				Meal.update(meal)
				Redirect(routes.MealController.meals)
			}
		)
	}

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
		findMeals(filter, request.user.id).map(meal => Ingredient.findByRecipe(meal.recipe.id)).flatten.sortWith((x, y) => x.name.compareTo(y.name) < 0).foreach(i =>
			ingredients.get((i.name, i.unit)) match {
				case None => ingredients += (i.name, i.unit) -> i
				case Some(x) => ingredients += (i.name, i.unit) -> i.copy(amount = i.amount + x.amount)
			}
		)
		Ok(views.html.meal_shopping_list(ingredients.values.toList))
	}

	val mealProposalForm = Form(
		mapping(
			"proposals" -> list(
				mapping(
					"recipeId" -> longNumber,
					"checked" -> boolean
				)(MealProposal.apply)(MealProposal.unapply)
			)
		)(MealProposals.apply)(MealProposals.unapply)
	)

	def mealProposal = Action { implicit request =>
		val proposals = MealProposals(List(MealProposal(1), MealProposal(2)))
		Ok(views.html.meal_proposal(mealProposalForm.fill(proposals)))
	}
}