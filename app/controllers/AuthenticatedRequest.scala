package controllers

import play.api.mvc._
import models._

case class AuthenticatedRequest(
	user: User, private val request: Request[AnyContent]) extends WrappedRequest(request)
