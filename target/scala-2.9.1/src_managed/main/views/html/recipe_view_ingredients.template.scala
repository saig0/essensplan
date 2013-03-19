
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import play.api.i18n._
import play.api.mvc._
import play.api.data._
import views.html._
/**/
object recipe_view_ingredients extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Long,List[Ingredient],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(recipeId: Long, ingredients: List[Ingredient]):play.api.templates.Html = {
        _display_ {import helper._

import tags._


Seq[Any](format.raw/*1.49*/("""

"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/main("Rezept")/*6.16*/ {_display_(Seq[Any](format.raw/*6.18*/("""
    
	"""),_display_(Seq[Any](/*8.3*/recipe_ingredients_view(recipeId, ingredients))),format.raw/*8.49*/("""
	
	"""),_display_(Seq[Any](/*10.3*/form(routes.Application.recipe(recipeId, "step=1"))/*10.54*/ {_display_(Seq[Any](format.raw/*10.56*/("""
		<input type="submit" value="weiter" />
	""")))})),format.raw/*12.3*/("""
	
	"""),_display_(Seq[Any](/*14.3*/form(routes.Application.recipe(recipeId, "info"))/*14.52*/ {_display_(Seq[Any](format.raw/*14.54*/("""
		<input type="submit" value="zurück" />
	""")))})),format.raw/*16.3*/("""
""")))})))}
    }
    
    def render(recipeId:Long,ingredients:List[Ingredient]) = apply(recipeId,ingredients)
    
    def f:((Long,List[Ingredient]) => play.api.templates.Html) = (recipeId,ingredients) => apply(recipeId,ingredients)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Dec 23 15:27:02 CET 2012
                    SOURCE: E:/Eigene Dateien/workspace-scala/essensplan/app/views/recipe_view_ingredients.scala.html
                    HASH: 0823460641ca35b1c310a6a18bd4565afad113fc
                    MATRIX: 538->1|693->48|721->82|757->84|779->98|818->100|860->108|927->154|967->159|1027->210|1067->212|1142->256|1182->261|1240->310|1280->312|1355->356
                    LINES: 19->1|25->1|27->5|28->6|28->6|28->6|30->8|30->8|32->10|32->10|32->10|34->12|36->14|36->14|36->14|38->16
                    -- GENERATED --
                */
            