
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
object importRecipe extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[String],Long,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(importForm: Form[String], recipeId: Long = 0):play.api.templates.Html = {
        _display_ {import helper._


Seq[Any](format.raw/*1.48*/("""
"""),format.raw/*3.1*/("""    
"""),_display_(Seq[Any](/*4.2*/main("Rezept importieren")/*4.28*/ {_display_(Seq[Any](format.raw/*4.30*/("""

	<h1>Rezept importieren</h1>	
	
	<p>
		von <a href="http://www.chefkoch.de/rezepte">chefkoch.de</a> unter Angabe der Id des Rezepts
		<i>( www.chefkoch.de/rezepte/"""),format.raw("""{"""),format.raw/*10.33*/("""REZEPT-ID"""),format.raw("""}"""),format.raw/*10.43*/(""" )</i>
	</p>
	
	<fieldset>
		"""),_display_(Seq[Any](/*14.4*/form(routes.RecipeImport.importRecipeWithId)/*14.48*/ {_display_(Seq[Any](format.raw/*14.50*/("""
			
			"""),_display_(Seq[Any](/*16.5*/inputText(importForm("recipeId"), '_label -> "Chefkoch-Rezept-Id"))),format.raw/*16.71*/("""
			
			<input type="submit" value="importieren" />
		""")))})),format.raw/*19.4*/("""
	</fieldset>
		
	"""),_display_(Seq[Any](/*22.3*/{ if(recipeId > 0) {
			
			form(routes.RecipeController.recipe(recipeId, "all")){ Html("""
				<p>Das Rezept wurde erfolgreich importiert!</p>
				<input type="submit" value="zum Rezept" />
				""")
			}
		} else if(recipeId < 0){
			<p>Das Rezept konnte nicht erfolgreich importiert werden!</p>
		}	
	})),format.raw/*32.3*/("""
""")))})),format.raw/*33.2*/("""
	
	"""))}
    }
    
    def render(importForm:Form[String],recipeId:Long) = apply(importForm,recipeId)
    
    def f:((Form[String],Long) => play.api.templates.Html) = (importForm,recipeId) => apply(importForm,recipeId)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Mar 28 12:12:49 CET 2013
                    SOURCE: E:/Eigene Dateien/workspace-scala/essensplan/app/views/importRecipe.scala.html
                    HASH: df1cf19f80df8f4b9befd56bde225b075aa215ae
                    MATRIX: 523->1|662->47|689->65|729->71|763->97|802->99|1015->265|1072->275|1137->305|1190->349|1230->351|1274->360|1362->426|1448->481|1502->500|1827->804|1860->806
                    LINES: 19->1|23->1|24->3|25->4|25->4|25->4|31->10|31->10|35->14|35->14|35->14|37->16|37->16|40->19|43->22|53->32|54->33
                    -- GENERATED --
                */
            