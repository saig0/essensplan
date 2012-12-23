package models

case class PreparationStep(id: Long, recipeId: Long, step: Int, description: String, imageRef: String)

object PreparationStep {
	import anorm._
	import anorm.SqlParser._
	import play.api.db._
	import play.api.Play.current
	
	val predarationStep = {
		get[Long]("id") ~
		get[Long]("recipeId") ~
		get[Int]("step") ~
		get[String]("description") ~
		get[String]("imageRef")  map {
			case id ~ recipeId ~ step ~ description ~ imageRef =>
				PreparationStep(id, recipeId, step, description, imageRef)
		}
	}
	
	def findByRecipe(recipeId: Long): List[PreparationStep] = DB.withConnection { implicit c =>
		SQL("select * from preparation_step where recipeId = {recipeId} order by step").on(
			'recipeId -> recipeId
		).as(predarationStep *)
	}
	
	def create(recipeId: Long, step: Int, description: String, imageRef: String): Long = { 
		DB.withConnection { implicit c =>
			SQL("insert into preparation_step (recipeId,step,description,imageRef) values ({recipeId}, {step}, {description}, {imageRef})").on(
				'recipeId 		-> recipeId,
				'step 			-> step,
				'description	-> description,
				'imageRef 		-> imageRef
			).executeInsert() match {
				case Some(id)	=> id
				case None		=> 0
			}
		}
	}
	
	def delete(id: Long) {
		DB.withConnection { implicit c =>
			SQL("delete from preparation_step where id = {id}").on(
				'id -> id
			).execute()
		}
	}
}
