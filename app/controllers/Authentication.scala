package controllers

import play.api.mvc._
import play.api.mvc.Results._
import models._

trait Authentication {

	def Authenticated(authRequest: AuthenticatedRequest => Result)(unauthRequest: Request[AnyContent] => Result) = {
		Action { request =>
			request.session.get("user") match {
				case Some(userId) => {
					val user = User.findById(userId.toLong)
					authRequest(AuthenticatedRequest(user, request))
				}
				case None => unauthRequest(request)
			}
		}
	}

	def AuthenticatedRequired(authRequest: AuthenticatedRequest => Result) =
		Authenticated(authRequest) { implicit request =>
			Ok(views.html.unauthenticated(request.uri))
		}
}