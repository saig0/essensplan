
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
    
	<h1>Neues Rezepte</h1>
	
	<fieldset>
		<legend>Informationen</legend>
		"""),_display_(Seq[Any](/*11.4*/form(
			if(recipeId == 0) routes.Application.createRecipe
			else routes.Application.updateRecipe(recipeId)
			)/*14.5*/{_display_(Seq[Any](format.raw/*14.6*/("""
			"""),_display_(Seq[Any](/*15.5*/inputText(recipeForm("name"), '_label -> "Name des Rezepts"))),format.raw/*15.65*/("""
			"""),_display_(Seq[Any](/*16.5*/inputRange(recipeForm("rating"), 0, 5, '_label -> "Bewertung"))),format.raw/*16.67*/("""
			"""),_display_(Seq[Any](/*17.5*/inputText(recipeForm("imageRef"), '_label -> "Link zu einem Bild"))),format.raw/*17.71*/("""
			"""),_display_(Seq[Any](/*18.5*/multiSelect(field = recipeForm("tags"), 
				options = options(tags),
				'_label -> "Stichwörter"
			))),format.raw/*21.5*/("""
	
	</fieldset>	

		<input type="submit" value="weiter" />
		""")))})),format.raw/*26.4*/("""
	
	<!--
		"""),_display_(Seq[Any](/*29.4*/form(routes.Application.recipes)/*29.36*/ {_display_(Seq[Any](format.raw/*29.38*/("""
			<input type="submit" value="abbrechen" />
		""")))})),format.raw/*31.4*/("""
	-->			
""")))})),format.raw/*33.2*/("""
"""))}
    }
    
    def render(recipeForm:Form[RecipeDTO],tags:Map[String, String],recipeId:Long) = apply(recipeForm,tags,recipeId)
    
    def f:((Form[RecipeDTO],Map[String, String],Long) => play.api.templates.Html) = (recipeForm,tags,recipeId) => apply(recipeForm,tags,recipeId)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Mar 20 00:19:06 CET 2013
                    SOURCE: E:/Eigene Dateien/workspace-scala/essensplan/app/views/recipe_new.scala.html
                    HASH: 0993cd370bc821baa6cd46c808a700554505815d
                    MATRIX: 544->1|713->77|741->96|777->98|800->113|839->115|954->195|1075->308|1113->309|1153->314|1235->374|1275->379|1359->441|1399->446|1487->512|1527->517|1651->620|1744->682|1791->694|1832->726|1872->728|1952->777|1993->787
                    LINES: 19->1|23->1|25->4|26->5|26->5|26->5|32->11|35->14|35->14|36->15|36->15|37->16|37->16|38->17|38->17|39->18|42->21|47->26|50->29|50->29|50->29|52->31|54->33
                    -- GENERATED --
                */
            