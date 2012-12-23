package models

case class Ingredient(id: Long, recipeId: Long, amount: Int, unit: String, name: String)

object Ingredient {
	
	import anorm._
	import anorm.SqlParser._
	import play.api.db._
	import play.api.Play.current
	
	val ingredient = {
		get[Long]("id") ~
		get[Long]("recipeId") ~
		get[Int]("amount") ~
		get[String]("unit") ~
		get[String]("name")  map {
			case id ~ recipeId ~ amount ~ unit ~ name =>
				Ingredient(id, recipeId, amount, unit, name)
		}
	}
	
	def findByRecipe(recipeId: Long): List[Ingredient] = DB.withConnection { implicit c =>
		SQL("select * from ingredient where recipeId = {recipeId}").on(
			'recipeId -> recipeId
		).as(ingredient *)
	}
		
	def create(recipeId: Long, amount: Int, unit: String, name: String): Long = { 
		DB.withConnection { implicit c =>
			SQL("insert into ingredient (recipeId,amount,unit,name) values ({recipeId}, {amount}, {unit}, {name})").on(
				'recipeId 	-> recipeId,
				'amount 	-> amount,
				'unit 		-> unit,
				'name 		-> name
			).executeInsert() match {
				case Some(id)	=> id
				case None		=> 0
			}
		}
	}
	
	def delete(id: Long) {
		DB.withConnection { implicit c =>
			SQL("delete from ingredient where id = {id}").on(
				'id -> id
			).execute()
		}
	}	
}
