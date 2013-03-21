package models

import java.util.Date

case class Meal(id: Long, recipeId: Long, date: Date, userId: Long)

case class MealDTO(id: Long, date: Date, recipe: Recipe)

object Meal {
	import anorm._
	import anorm.SqlParser._
	import play.api.db._
	import play.api.Play.current
	
	val meal = {
		get[Long]("id") ~
		get[Long]("recipeId") ~
		get[Date]("date") ~
		get[Long]("userId") map {
			case id ~ recipeId ~ date ~ userId =>
				Meal(id, recipeId, date, userId)
		}
	}
	
	def findByRecipe(recipeId: Long, userId: Long): List[Meal] = DB.withConnection { implicit c =>
		SQL("select * from meal where recipeId = {recipeId} and userId = {userId} order by date desc").on(
			'recipeId	-> recipeId,
			'userId		-> userId
		).as(meal *)
	}
	
	def findByDate(from: Date, to: Date, userId: Long): List[Meal] = DB.withConnection { implicit c =>
		SQL("select * from meal where date >= {from} and date <= {to} and userId = {userId} order by date asc").on(
			'from	-> from,
			'to		-> to,
			'userId	-> userId
		).as(meal *)
	}
	
	def findById(id: Long): Meal = DB.withConnection { implicit c =>
		SQL("select * from meal where id = {id}").on(
			'id		-> id
		).as(meal.single)
	}
	
	def create(recipeId: Long, date: Date, userId: Long): Long = { 
		DB.withConnection { implicit c =>
			SQL("insert into meal (recipeId,date,userId) values ({recipeId}, {date}, {userId})").on(
				'recipeId 		-> recipeId,
				'date 			-> date,
				'userId			-> userId
			).executeInsert() match {
				case Some(id)	=> id
				case None		=> 0
			}
		}
	}
	
	def update(meal: Meal) { DB.withConnection { implicit c =>
		SQL("update meal SET recipeId = {recipeId}, date = {date} where id = {id}").on(
				'id 		-> meal.id,
				'recipeId	-> meal.recipeId,
				'date		-> meal.date
			).executeUpdate()
		}
	}
	
	def delete(id: Long) {
		DB.withConnection { implicit c =>
			SQL("delete from meal where id = {id}").on(
				'id -> id
			).execute()
		}
	}
	
	def toDTO(meal: Meal) = {
		val recipe = Recipe.findById(meal.recipeId)
		MealDTO(meal.id, meal.date, recipe)
	}
}
