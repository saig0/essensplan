package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.templates._
import play.api.libs.ws.WS
import play.api.libs.openid._
import play.api.libs.openid.Errors._
import play.api.libs.concurrent._
import models._
import java.util.Date
import java.text.SimpleDateFormat
import scala.xml._

object Application extends Controller with Authentication {

	def index = Authenticated { implicit request =>
		Redirect(routes.MealController.meals)
	} { implicit request =>
		Redirect(routes.RecipeController.recipes)
	}

}