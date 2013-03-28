package controllers

import play.api.data._
import play.api.data.Forms._
import play.api.mvc._
import play.api.templates._
import models._
import controllers.Application._
import controllers.RecipeController._

object RecipeCreator extends Controller with Authentication {

	val recipeForm: Form[RecipeDTO] = Form(
		mapping(
			"name" -> nonEmptyText,
			"rating" -> number(min = 0, max = 5),
			"imageRef" -> text,
			"source" -> text,
			"tags" -> list(text)
		)((name, rating, image, source, tags) => RecipeDTO(0, name, rating, image, source, tags.map(tag => new Tag(tag.toInt, "", 0))))((recipe: RecipeDTO) => Some((recipe.name, recipe.rating, recipe.imageRef, recipe.source, recipe.tags.map(_.id.toString))))
	)

	val ingredientForm: Form[Ingredient] = Form(
		mapping(
			"amount" -> number(min = 0),
			"unit" -> nonEmptyText,
			"name" -> nonEmptyText
		)((amount, unit, name) => Ingredient(0, 0, amount, unit, name))((ingredient: Ingredient) => Some((ingredient.amount, ingredient.unit, ingredient.name)))
	)

	val preparationStepForm: Form[PreparationStep] = Form(
		mapping(
			"step" -> number(min = 1),
			"description" -> nonEmptyText,
			"imageRef" -> text
		)((step, description, imageRef) => PreparationStep(0, 0, step, description, imageRef))((preparationStep: PreparationStep) => Some((preparationStep.step, preparationStep.description, preparationStep.imageRef)))
	)

	private def showNewRecipe(form: Form[RecipeDTO], recipeId: Long = 0) = AuthenticatedRequired { implicit request =>
		Ok(views.html.recipe_new(form, tagOptions(request.user.id), recipeId))
	}

	def newRecipe = showNewRecipe(recipeForm)

	def editRecipe(recipeId: Long) = AuthenticatedRequired { implicit request =>
		val r = Recipe.findById(recipeId)
		if (r.userId == request.user.id) {
			val recipe = Recipe.toDto(r)
			val filledRecipeForm = recipeForm.fill(recipe)
			Ok(views.html.recipe_new(filledRecipeForm, tagOptions(request.user.id), recipeId))
		} else {
			Ok(views.html.index("Nur der Author darf das Rezept ändern!"))
		}
	}

	def removeRecipe(recipeId: Long) = AuthenticatedRequired { implicit request =>
		val r = Recipe.findById(recipeId)
		if (r.userId == request.user.id) {
			Recipe.delete(recipeId)
			Redirect(routes.RecipeController.recipes)
		} else {
			Ok(views.html.index("Nur der Author darf das Rezept löschen!"))
		}
	}

	def createRecipe = AuthenticatedRequired { implicit request =>
		recipeForm.bindFromRequest.fold(
			errors => {
				BadRequest(views.html.recipe_new(errors, tagOptions(request.user.id)))
			},
			recipe => {
				val id = Recipe.create(recipe.name, recipe.rating, recipe.imageRef, recipe.source, request.user.id)
				val tags = extractTags(request.body.asFormUrlEncoded)
				tags.map(tagId => RecipeTag.create(id, tagId))
				val r = new Recipe(id, recipe.name, recipe.rating, recipe.imageRef, recipe.source, request.user.id)
				Redirect(routes.RecipeCreator.recipeIngredients(r.id))
			}
		)
	}

	private def extractTags(url: Option[Map[String, Seq[String]]]): List[Long] = url match {
		case None => List[Long]()
		case Some(params) => params.get("tags") match {
			case None => List[Long]()
			case Some(tags) => tags.map(_.toLong).toList
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
		ingredientForm.bindFromRequest.fold(
			errors => BadRequest(views.html.recipe_new_ingredients(recipe, ingredients, errors)),
			ingredient => {
				val id = Ingredient.create(recipeId, ingredient.amount, ingredient.unit, ingredient.name)
				val i = new Ingredient(id, recipeId, ingredient.amount, ingredient.unit, ingredient.name)
				Ok(views.html.recipe_new_ingredients(recipe, ingredients ++ (i :: Nil), ingredientForm))
			}
		)
	}

	def removeRecipeIngredient(recipeId: Long, ingredientId: Long) = Action { implicit request =>
		Ingredient.delete(ingredientId)
		Redirect(routes.RecipeCreator.recipeIngredients(recipeId))
	}

	def updateRecipe(recipeId: Long) = AuthenticatedRequired { implicit request =>
		recipeForm.bindFromRequest.fold(
			errors => {
				BadRequest(views.html.recipe_new(errors, tagOptions(request.user.id)))
			},
			recipe => {
				val r = new Recipe(recipeId, recipe.name, recipe.rating, recipe.imageRef, recipe.source, 0)
				val tags = extractTags(request.body.asFormUrlEncoded)
				RecipeTag.findByRecipe(recipeId).map(recipeTag =>
					if (!tags.contains(recipeTag.tagId)) {
						RecipeTag.delete(recipeTag.id)
					}
				)
				tags.diff(RecipeTag.findByRecipe(recipeId).map(_.tagId)).map(tagId => RecipeTag.create(recipeId, tagId))
				Recipe.update(r)
				Redirect(routes.RecipeCreator.recipeIngredients(recipeId))
			}
		)
	}

	def recipePreparation(recipeId: Long) = Action { implicit request =>
		val recipe = Recipe.findById(recipeId)
		var preparationSteps = PreparationStep.findByRecipe(recipeId)
		Ok(views.html.recipe_new_preparation(recipe, preparationSteps, preparationStepForm))
	}

	def addPreparationStep(recipeId: Long) = Action { implicit request =>
		val recipe = Recipe.findById(recipeId)
		var preparationSteps = PreparationStep.findByRecipe(recipeId)
		preparationStepForm.bindFromRequest.fold(
			errors => BadRequest(views.html.recipe_new_preparation(recipe, preparationSteps, errors)),
			preparationStep => {
				val id = PreparationStep.create(recipeId, preparationStep.step, preparationStep.description, preparationStep.imageRef)
				val p = new PreparationStep(id, recipeId, preparationStep.step, preparationStep.description, preparationStep.imageRef)
				Ok(views.html.recipe_new_preparation(recipe, preparationSteps ++ (p :: Nil), preparationStepForm))
			}
		)
	}

	def removePreparationStep(recipeId: Long, preparationStepId: Long) = Action { implicit request =>
		PreparationStep.delete(preparationStepId)
		Redirect(routes.RecipeCreator.recipePreparation(recipeId))
	}

	// ---------------------------------------------------

	// ----------------

}