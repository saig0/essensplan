
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
			if(recipeId == 0) routes.RecipeCreator.createRecipe
			else routes.RecipeCreator.updateRecipe(recipeId)
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

		""")))})),format.raw/*28.4*/("""
""")))})),format.raw/*29.2*/("""
"""))}
    }
    
    def render(recipeForm:Form[RecipeDTO],tags:Map[String, String],recipeId:Long) = apply(recipeForm,tags,recipeId)
    
    def f:((Form[RecipeDTO],Map[String, String],Long) => play.api.templates.Html) = (recipeForm,tags,recipeId) => apply(recipeForm,tags,recipeId)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Mar 28 12:17:38 CET 2013
                    SOURCE: E:/Eigene Dateien/workspace-scala/essensplan/app/views/recipe_new.scala.html
                    HASH: 9ecbeb48d0751d60d2060cf5272628a4e0950019
                    MATRIX: 544->1|713->77|741->96|777->98|800->113|839->115|885->127|962->183|1053->239|1178->356|1216->357|1256->362|1338->422|1378->427|1462->489|1502->494|1590->560|1630->565|1704->617|1744->622|1868->725|1961->787|1994->789
                    LINES: 19->1|23->1|25->4|26->5|26->5|26->5|28->7|28->7|32->11|35->14|35->14|36->15|36->15|37->16|37->16|38->17|38->17|39->18|39->18|40->19|43->22|49->28|50->29
                    -- GENERATED --
                */
            