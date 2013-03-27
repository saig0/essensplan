
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
object meal_shopping_list extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[List[Ingredient],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(ingredients: List[Ingredient]):play.api.templates.Html = {
        _display_ {import helper._

import tags._


Seq[Any](format.raw/*1.33*/("""

"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/main("Einkaufsliste")/*6.23*/ {_display_(Seq[Any](format.raw/*6.25*/("""	
		
	<h1>Einkaufsliste</h1>	
		
	<table border="1">
		<tr>
			<th>Zutat</th>
			<th>Menge</th>
			<th>Anzahl</th>
		</tr>
	
		"""),_display_(Seq[Any](/*17.4*/ingredients/*17.15*/.map/*17.19*/ { ingredient =>_display_(Seq[Any](format.raw/*17.35*/("""
			<tr>
				<td>"""),_display_(Seq[Any](/*19.10*/ingredient/*19.20*/.name)),format.raw/*19.25*/("""</td>
				<td>"""),_display_(Seq[Any](/*20.10*/ingredient/*20.20*/.amount)),format.raw/*20.27*/("""</td>
				<td>"""),_display_(Seq[Any](/*21.10*/ingredient/*21.20*/.unit)),format.raw/*21.25*/("""</td>
			</tr>
		""")))})),format.raw/*23.4*/("""	
	</table>	
""")))})))}
    }
    
    def render(ingredients:List[Ingredient]) = apply(ingredients)
    
    def f:((List[Ingredient]) => play.api.templates.Html) = (ingredients) => apply(ingredients)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Mar 27 10:57:19 CET 2013
                    SOURCE: E:/Eigene Dateien/workspace-scala/essensplan/app/views/meal_shopping_list.scala.html
                    HASH: 01f50487767ad3eeb79bb01a387a3f62d9cf1ff2
                    MATRIX: 528->1|667->32|695->66|731->68|760->89|799->91|962->219|982->230|995->234|1049->250|1103->268|1122->278|1149->283|1200->298|1219->308|1248->315|1299->330|1318->340|1345->345|1394->363
                    LINES: 19->1|25->1|27->5|28->6|28->6|28->6|39->17|39->17|39->17|39->17|41->19|41->19|41->19|42->20|42->20|42->20|43->21|43->21|43->21|45->23
                    -- GENERATED --
                */
            