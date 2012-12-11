package models

case class Essen(name: String, verweis: String, tag: String)

object Essen {

	import anorm._
	import anorm.SqlParser._
	import play.api.db._
	import play.api.Play.current

	val essen = {
		get[String]("name") ~
		get[String]("verweis") ~
		get[String]("tag") map {
			case name~verweis~tag => Essen(name, verweis, tag)
		}
	}
	
	def alle: List[Essen] = DB.withConnection { implicit c =>
		SQL("select * from essen").as(essen *)
	}
	
	def neu(name: String, verweis: String, tag: String) { 
		DB.withConnection { implicit c =>
			SQL("insert into essen (name,verweis,tag) values ({name}, {verweis}, {tag})").on(
				'name -> name,
				'verweis -> verweis,
				'tag -> tag
			).executeUpdate()
		}
	}
	
	def entfernen(name: String) {
		DB.withConnection { implicit c =>
			SQL("delete from essen where name = {name}").on(
				'name -> name
			).executeUpdate()
		}
	}

}