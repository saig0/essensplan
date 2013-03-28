
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
	
	"""),_display_(Seq[Any](/*10.3*/form(routes.RecipeController.recipe(recipeId, "step=1"))/*10.59*/ {_display_(Seq[Any](format.raw/*10.61*/("""
		<input type="submit" value="weiter" />
	""")))})),format.raw/*12.3*/("""
	
	"""),_display_(Seq[Any](/*14.3*/form(routes.RecipeController.recipe(recipeId, "info"))/*14.57*/ {_display_(Seq[Any](format.raw/*14.59*/("""
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
                    DATE: Thu Mar 28 12:16:03 CET 2013
                    SOURCE: E:/Eigene Dateien/workspace-scala/essensplan/app/views/recipe_view_ingredients.scala.html
                    HASH: 961e52e09bb7a0de3408964d1a750696800f593d
                    MATRIX: 538->1|693->48|721->82|757->84|779->98|818->100|860->108|927->154|967->159|1032->215|1072->217|1147->261|1187->266|1250->320|1290->322|1365->366
                    LINES: 19->1|25->1|27->5|28->6|28->6|28->6|30->8|30->8|32->10|32->10|32->10|34->12|36->14|36->14|36->14|38->16
                    -- GENERATED --
                */
            