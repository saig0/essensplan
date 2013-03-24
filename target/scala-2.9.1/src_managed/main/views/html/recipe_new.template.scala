
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
object recipe_new extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Form[RecipeDTO],Map[String, String],Long,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(recipeForm: Form[RecipeDTO], tags: Map[String, String], recipeId: Long = 0):play.api.templates.Html = {
        _display_ {import helper._


Seq[Any](format.raw/*1.78*/("""

"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/main("Rezepte")/*5.17*/ {_display_(Seq[Any](format.raw/*5.19*/("""
    
	<h1>"""),_display_(Seq[Any](/*7.7*/{if(recipeId == 0) "Neues Rezepte" else "Rezept ändern"})),format.raw/*7.63*/("""</h1>
	
	<fieldset>
		<legend>Informationen</legend>
		"""),_display_(Seq[Any](/*11.4*/form(
			if(recipeId == 0) routes.Application.createRecipe
			else routes.Application.updateRecipe(recipeId)
			)/*14.5*/{_display_(Seq[Any](format.raw/*14.6*/("""
			"""),_display_(Seq[Any](/*15.5*/inputText(recipeForm("name"), '_label -> "Name des Rezepts"))),format.raw/*15.65*/("""
			"""),_display_(Seq[Any](/*16.5*/inputRange(recipeForm("rating"), 0, 5, '_label -> "Bewertung"))),format.raw/*16.67*/("""
			"""),_display_(Seq[Any](/*17.5*/inputText(recipeForm("imageRef"), '_label -> "Link zu einem Bild"))),format.raw/*17.71*/("""
			"""),_display_(Seq[Any](/*18.5*/inputText(recipeForm("source"), '_label -> "Quelle"))),format.raw/*18.57*/("""
			"""),_display_(Seq[Any](/*19.5*/multiSelect(field = recipeForm("tags"), 
				options = options(tags),
				'_label -> "Stichwörter"
			))),format.raw/*22.5*/("""
	
	</fieldset>	

		<input type="submit" value="weiter" />
		""")))})),format.raw/*27.4*/("""
	
	<!--
		"""),_display_(Seq[Any](/*30.4*/form(routes.Application.recipes)/*30.36*/ {_display_(Seq[Any](format.raw/*30.38*/("""
			<input type="submit" value="abbrechen" />
		""")))})),format.raw/*32.4*/("""
	-->			
""")))})),format.raw/*34.2*/("""
"""))}
    }
    
    def render(recipeForm:Form[RecipeDTO],tags:Map[String, String],recipeId:Long) = apply(recipeForm,tags,recipeId)
    
    def f:((Form[RecipeDTO],Map[String, String],Long) => play.api.templates.Html) = (recipeForm,tags,recipeId) => apply(recipeForm,tags,recipeId)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Mar 24 13:51:09 CET 2013
                    SOURCE: E:/Eigene Dateien/workspace-scala/essensplan/app/views/recipe_new.scala.html
                    HASH: 117f4bd419e5fefce61b38118a0dc5932dd5b457
                    MATRIX: 544->1|713->77|741->96|777->98|800->113|839->115|885->127|962->183|1053->239|1174->352|1212->353|1252->358|1334->418|1374->423|1458->485|1498->490|1586->556|1626->561|1700->613|1740->618|1864->721|1957->783|2004->795|2045->827|2085->829|2165->878|2206->888
                    LINES: 19->1|23->1|25->4|26->5|26->5|26->5|28->7|28->7|32->11|35->14|35->14|36->15|36->15|37->16|37->16|38->17|38->17|39->18|39->18|40->19|43->22|48->27|51->30|51->30|51->30|53->32|55->34
                    -- GENERATED --
                */
            