package controllers

import play.api.mvc._
import play.api.libs.ws.WS
import play.api.libs.openid._
import play.api.libs.openid.Errors._
import play.api.libs.concurrent._
import models._

object AuthenticationController extends Controller {

	val openid = "www.google.com/accounts/o8/id"

	def login(uri: String) = Action { implicit request =>
		val redirectUrl = routes.AuthenticationController.openIDCallback(uri.substring(1)).absoluteURL()
		AsyncResult(OpenID.redirectURL(openid, redirectUrl,
			Seq("email" -> "http://schema.openid.net/contact/email"))
			.extend(_.value match {
				case Redeemed(url) => Redirect(url)
				case e: OpenIDError => Ok { "Fehler bei der Anmeldung über OpenId: " + e.message }
			}))
	}

	def openIDCallback(uri: String) = Action { implicit request =>
		AsyncResult(
			OpenID.verifiedId.extend(_.value match {
				case Redeemed(info) => {
					val email = info.attributes("email")
					val userId = User.findByEmail(email) match {
						case Some(user) => user.id
						case None => User.create(email)
					}
					val redirectUrl = "http://" + request.host + "/" + uri
					Redirect(redirectUrl).withSession(
						session + ("user" -> userId.toString)
					)
				}
				case e: OpenIDError => Ok { "Fehler bei der Anmeldung über OpenId: " + e.message }
			})
		)
	}

	def logout = Action { implicit request =>
		Redirect(routes.Application.index).withNewSession
	}
}