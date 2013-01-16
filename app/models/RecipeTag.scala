package models

case class RecipeTag(id: Long, recipeId: Long, tagId: Long)

object RecipeTag {

	import anorm._
	import anorm.SqlParser._
	import play.api.db._
	import play.api.Play.current

	val recipeTag = {
		get[Long]("id") ~ 
		get[Long]("recipeId") ~ 
		get[Long]("tagId") map {
			case id~recipeId~tagId => RecipeTag(id, recipeId, tagId)
		}
	}
	
	def all: List[RecipeTag] = DB.withConnection { implicit c =>
		SQL("select * from recipe_tag").as(recipeTag *)
	}
		
	def create(recipeId: Long, tagId: Long): Long = { 
		DB.withConnection { implicit c =>
			SQL("insert into recipe_tag (recipeId, tagId) values ({recipeId}, {tagId})").on(
				'recipeId	-> recipeId,
				'tagId 		-> tagId
			).executeInsert() match {
				case Some(id)	=> id
				case None		=> 0
			}
		}
	}
	
	def delete(id: Long) {
		DB.withConnection { implicit c =>
			SQL("delete from recipe_tag where id = {id}").on(
				'id -> id
			).execute()
		}
	}
	
	def findById(id: Long): RecipeTag = DB.withConnection { implicit c =>
		SQL("select * from recipe_tag where id = {id}").on(
			'id -> id
		).as(recipeTag.single)
	}

	def findByRecipe(recipeId: Long): List[RecipeTag] = DB.withConnection { implicit c =>
		SQL("select * from recipe_tag where recipeId = {recipeId}").on(
			'recipeId -> recipeId
		).as(recipeTag *)
	}
}