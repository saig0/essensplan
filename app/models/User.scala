package models

case class User(id: Long, email: String)

object User {

	import anorm._
	import anorm.SqlParser._
	import play.api.db._
	import play.api.Play.current

	val user = {
		get[Long]("id") ~ 
		get[String]("email") map {
			case id~email => User(id, email)
		}
	}
	
	def findById(id: Long): User = DB.withConnection { implicit c =>
		SQL("select * from users where id = {id}").on(
			'id -> id
		).as(user.single)
	}
	
	def findByEmail(email: String): Option[User] = DB.withConnection { implicit c =>
		SQL("select * from users where email = {email}").on(
			'email -> email
		).as(user.singleOpt)
	}
	
	def create(email: String): Long = { 
		DB.withConnection { implicit c =>
			SQL("insert into users (email) values ({email})").on(
				'email 		-> email
			).executeInsert() match {
				case Some(id)	=> id
				case None		=> 0
			}
		}
	}
}