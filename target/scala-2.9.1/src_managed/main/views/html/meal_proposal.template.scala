
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
object meal_proposal extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[MealProposals],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(mealProposalForm: Form[MealProposals]):play.api.templates.Html = {
        _display_ {import helper._

import tags._


Seq[Any](format.raw/*1.41*/("""

"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/main("Essensplan")/*6.20*/ {_display_(Seq[Any](format.raw/*6.22*/("""
	
	<h1>Vorschläge</h1>
	
	<table border="1">
	"""),_display_(Seq[Any](/*11.3*/repeat(mealProposalForm("proposals"))/*11.40*/ { proposal =>_display_(Seq[Any](format.raw/*11.54*/("""
		<tr><td>
		"""),_display_(Seq[Any](/*13.4*/inputText(proposal("recipeId"), '_label -> ""))),format.raw/*13.50*/("""
		</td><td>
		"""),_display_(Seq[Any](/*15.4*/checkbox(proposal("checked"), '_label -> ""))),format.raw/*15.48*/("""
		</td></tr>	
	""")))})),format.raw/*17.3*/("""
	</table>
""")))})))}
    }
    
    def render(mealProposalForm:Form[MealProposals]) = apply(mealProposalForm)
    
    def f:((Form[MealProposals]) => play.api.templates.Html) = (mealProposalForm) => apply(mealProposalForm)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Mar 27 10:57:19 CET 2013
                    SOURCE: E:/Eigene Dateien/workspace-scala/essensplan/app/views/meal_proposal.scala.html
                    HASH: 2a1aabc7f1039cc5fa9381ed33e28d6b3224e937
                    MATRIX: 526->1|673->40|701->74|737->76|763->94|802->96|885->144|931->181|983->195|1033->210|1101->256|1152->272|1218->316|1266->333
                    LINES: 19->1|25->1|27->5|28->6|28->6|28->6|33->11|33->11|33->11|35->13|35->13|37->15|37->15|39->17
                    -- GENERATED --
                */
            