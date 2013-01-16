package models

case class Tag(id: Long, name: String)

object Tag {

	import anorm._
	import anorm.SqlParser._
	import play.api.db._
	import play.api.Play.current

	val tag = {
		get[Long]("id") ~ 
		get[String]("name") map {
			case id~name => Tag(id, name)
		}
	}
	
	def all: List[Tag] = DB.withConnection { implicit c =>
		SQL("select * from tag").as(tag *)
	}
	
	def tagNames: List[String] = DB.withConnection { implicit c =>
		SQL("select name from tag order by name asc").as(get[String]("name") *)
	}
	
	def create(name: String): Long = { 
		DB.withConnection { implicit c =>
			SQL("insert into tag (name) values ({name})").on(
				'name 		-> name
			).executeInsert() match {
				case Some(id)	=> id
				case None		=> 0
			}
		}
	}
	
	def delete(id: Long) {
		DB.withConnection { implicit c =>
			SQL("delete from tag where id = {id}").on(
				'id -> id
			).execute()
		}
	}
	
	def findById(id: Long): Tag = DB.withConnection { implicit c =>
		SQL("select * from tag where id = {id}").on(
			'id -> id
		).as(tag.single)
	}

	
	def update(tag: Tag) { DB.withConnection { implicit c =>
		SQL("update tag SET name = {name} where id = {id}").on(
				'id 		-> tag.id,
				'name 		-> tag.name
			).executeUpdate()
		}
	}
}