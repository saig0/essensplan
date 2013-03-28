package controllers

import play.api.data._
import play.api.data.Forms._
import play.api.mvc._
import models._

object TagController extends Controller with Authentication {

	val tagForm: Form[Tag] = Form(
		mapping(
			"name" -> nonEmptyText
		)((name) => Tag(0, name, 0))((tag: Tag) => Some((tag.name)))
	)

	def tags = AuthenticatedRequired { implicit request =>
		Ok(views.html.tag_list(Tag.findByUser(request.user.id), tagForm))
	}

	def tagNew = AuthenticatedRequired { implicit request =>
		tagForm.bindFromRequest.fold(
			errors => BadRequest(views.html.tag_list(Tag.findByUser(request.user.id), errors)),
			filter => {
				Tag.create(filter.name, request.user.id)
				Redirect(routes.TagController.tags)
			}
		)
	}

	def tagRemove(tagId: Long) = AuthenticatedRequired { implicit request =>
		Tag.delete(tagId)
		Redirect(routes.TagController.tags)
	}

	def tagEdit(tagId: Long) = AuthenticatedRequired { implicit request =>
		Ok(views.html.tag_list(Tag.findByUser(request.user.id), tagForm.fill(Tag.findById(tagId)), tagId))
	}

	def tagUpdate(tagId: Long) = AuthenticatedRequired { implicit request =>
		tagForm.bindFromRequest.fold(
			errors => BadRequest(views.html.tag_list(Tag.findByUser(request.user.id), errors)),
			filter => {
				val tag = Tag.findById(tagId).copy(name = filter.name)
				Tag.update(tag)
				Redirect(routes.TagController.tags)
			}
		)
	}
}