package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import models._
import models.Essen._

object Application extends Controller {
  
  def index = Action {
    Redirect(routes.Application.essen)
  }
  
  def essen = Action {
	Ok(views.html.index(Essen.alle, essenForm))
  }
  
  def neuesEssen = Action { implicit request =>
	essenForm.bindFromRequest.fold (
		errors => BadRequest(views.html.index(Essen.alle, errors)),
		e => {
			Essen.neu(e.name, e.verweis, e.tag)
			Redirect(routes.Application.essen)
		}
	)
  }
  
  def entferneEssen(name: String) =  Action {
	Essen.entfernen(name)
	Redirect(routes.Application.essen)
  }
  
  val essenForm: Form[Essen] = Form (
	mapping (
		"name" -> nonEmptyText,
		"verweis" -> nonEmptyText,
		"tag" -> nonEmptyText
		)(Essen.apply)(Essen.unapply)
	)
}