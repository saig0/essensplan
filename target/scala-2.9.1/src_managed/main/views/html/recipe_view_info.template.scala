
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
object recipe_view_info extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[RecipeDTO,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(recipe: RecipeDTO):play.api.templates.Html = {
        _display_ {import helper._

import tags._


Seq[Any](format.raw/*1.21*/("""

"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/main("Rezept")/*6.16*/ {_display_(Seq[Any](format.raw/*6.18*/("""
    
	<h1>Rezept: """),_display_(Seq[Any](/*8.15*/recipe/*8.21*/.name)),format.raw/*8.26*/("""</h1>
	
	"""),_display_(Seq[Any](/*10.3*/form(routes.Application.recipe(recipe.id, "all"))/*10.52*/ {_display_(Seq[Any](format.raw/*10.54*/("""
		<input type="submit" value="Gesamtübersicht" />
	""")))})),format.raw/*12.3*/("""
	
	"""),_display_(Seq[Any](/*14.3*/recipe_info_view(recipe))),format.raw/*14.27*/("""
	
	"""),_display_(Seq[Any](/*16.3*/form(routes.Application.recipe(recipe.id, "ingredients"))/*16.60*/ {_display_(Seq[Any](format.raw/*16.62*/("""
		<input type="submit" value="weiter" />
	""")))})),format.raw/*18.3*/("""
""")))})))}
    }
    
    def render(recipe:RecipeDTO) = apply(recipe)
    
    def f:((RecipeDTO) => play.api.templates.Html) = (recipe) => apply(recipe)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Mar 27 10:57:19 CET 2013
                    SOURCE: E:/Eigene Dateien/workspace-scala/essensplan/app/views/recipe_view_info.scala.html
                    HASH: 95258a22d4ae65650d0762aa5ad75540fc0814a3
                    MATRIX: 519->1|646->20|674->54|710->56|732->70|771->72|826->92|840->98|866->103|911->113|969->162|1009->164|1093->217|1133->222|1179->246|1219->251|1285->308|1325->310|1400->354
                    LINES: 19->1|25->1|27->5|28->6|28->6|28->6|30->8|30->8|30->8|32->10|32->10|32->10|34->12|36->14|36->14|38->16|38->16|38->16|40->18
                    -- GENERATED --
                */
            