package models

case class Recipe(id: Long, name: String,  rating: Int, imageRef: String, tags: String)

object Recipe {

	import anorm._
	import anorm.SqlParser._
	import play.api.db._
	import play.api.Play.current

	val recipe = {
		get[Long]("id") ~ 
		get[String]("name") ~
		get[Int]("rating") ~
		get[String]("imageRef") ~
		get[String]("tags")	map {
			case id~name~rating~imageRef~tags => Recipe(id, name, rating, imageRef, tags)
		}
	}
	
	def all: List[Recipe] = DB.withConnection { implicit c =>
		SQL("select * from recipe").as(recipe *)
	}
	
	def create(name: String, rating: Int, imageRef: String, tags: String): Long = { 
		DB.withConnection { implicit c =>
			SQL("insert into recipe (name,rating,imageRef, tags) values ({name}, {rating}, {imageRef}, {tags})").on(
				'name 		-> name,
				'rating 	-> rating,
				'imageRef 	-> imageRef,
				'tags 		-> tags
			).executeInsert() match {
				case Some(id)	=> id
				case None		=> 0
			}
		}
	}
	
	def delete(id: Long) {
		DB.withConnection { implicit c =>
			SQL("delete from recipe where id = {id}").on(
				'id -> id
			).execute()
		}
	}
	
	def findById(id: Long): Recipe = DB.withConnection { implicit c =>
		SQL("select * from recipe where id = {id}").on(
			'id -> id
		).as(recipe.single)
	}

	def update(recipe: Recipe) { DB.withConnection { implicit c =>
		SQL("update recipe SET name = {name}, rating = {rating}, imageRef = {imageRef}, tags = {tags} where id = {id}").on(
				'id 		-> recipe.id,
				'name 		-> recipe.name,
				'rating 	-> recipe.rating,
				'imageRef 	-> recipe.imageRef,
				'tags 		-> recipe.tags
			).executeUpdate()
		}
	}
	
	def find(name: String, rating: Int, ingredient: String, sorting: Int): List[Recipe] = {
		val mode = if (sorting > 0) "ASC NULLS FIRST" else "DESC NULLS LAST"
		DB.withConnection { implicit c => 
			SQL("""
				select r2.*
				from recipe r2, (
					select distinct r.id
					from recipe r
						right join ingredient i 
							on r.id = i.recipeId
					where ( lower(r.name) like {name} or lower(r.tags) like {name} ) 
						and r.rating >= {rating} 
						and lower(i.name) like {ingredient}
					) r3
				where r2.id = r3.id
				order by %d %s
				""".format(scala.math.abs(sorting), mode)
			).on(
				'name 		-> ("%" + name.toLowerCase + "%"),
				'rating 	-> rating,
				'ingredient	-> ("%" + ingredient.toLowerCase + "%")
			).as(recipe *)
		}
	}
}