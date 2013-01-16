package models

case class Recipe(id: Long, name: String,  rating: Int, imageRef: String)

case class RecipeDTO(id: Long, name: String,  rating: Int, imageRef: String, tags: List[Tag])

object Recipe {

	import anorm._
	import anorm.SqlParser._
	import play.api.db._
	import play.api.Play.current

	val recipe = {
		get[Long]("id") ~ 
		get[String]("name") ~
		get[Int]("rating") ~
		get[String]("imageRef")	map {
			case id~name~rating~imageRef => Recipe(id, name, rating, imageRef)
		}
	}
	
	def all: List[Recipe] = DB.withConnection { implicit c =>
		SQL("select * from recipe").as(recipe *)
	}
	
	def create(name: String, rating: Int, imageRef: String): Long = { 
		DB.withConnection { implicit c =>
			SQL("insert into recipe (name,rating,imageRef) values ({name}, {rating}, {imageRef})").on(
				'name 		-> name,
				'rating 	-> rating,
				'imageRef 	-> imageRef
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
		SQL("update recipe SET name = {name}, rating = {rating}, imageRef = {imageRef} where id = {id}").on(
				'id 		-> recipe.id,
				'name 		-> recipe.name,
				'rating 	-> recipe.rating,
				'imageRef 	-> recipe.imageRef
			).executeUpdate()
		}
	}
	
	def find(name: String, tag: String, rating: Int, ingredient: String, sorting: Int): List[Recipe] = {
		val mode = if (sorting > 0) "ASC NULLS FIRST" else "DESC NULLS LAST"
		DB.withConnection { implicit c => 
			SQL("""
				select r2.*
				from recipe r2
				where r2.id in (
					select r.id
					from recipe r
						left join ingredient i 
							on r.id = i.recipeId
					where lower(r.name) like {name}
						and r.rating >= {rating} 
						and (i.name is not null and lower(i.name) like {ingredient})
						and ({tag} = 0 or {tag} in (
								select rt.tagId
								from recipe_tag rt
								where r.id = rt.recipeId
							)
						)
				)
				order by %d %s
				""".format(scala.math.abs(sorting), mode)
			).on(
				'name 		-> ("%" + name.toLowerCase + "%"),
				'tag		-> (if(!tag.isEmpty) tag.toLong else 0),
				'rating 	-> rating,
				'ingredient	-> ("%" + ingredient.toLowerCase + "%")
			).as(recipe *)
		}
	}
	
	def toDto(recipe: Recipe): RecipeDTO = {
		val tags = RecipeTag.findByRecipe(recipe.id).map(recipeTag => Tag.findById(recipeTag.tagId))
		RecipeDTO(recipe.id, recipe.name, recipe.rating, recipe.imageRef, tags)
	}
}