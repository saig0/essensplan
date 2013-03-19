
package views.html.tags

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
object recipe_ingredients_view extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Long,List[Ingredient],_root_.scala.Function1[Ingredient, List[Html]],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(recipeId: Long, ingredients: List[Ingredient], render: Ingredient => List[Html] = ( _ => List[Html]())):play.api.templates.Html = {
        _display_ {import helper._


Seq[Any](format.raw/*1.106*/("""

"""),format.raw/*4.1*/("""
    
	<h2>Zutaten</h2>
	
	<table border="1">
		<tr>
			<th>Menge</th>
			<th>Einheit</th>
			<th>Zutat</th>
		</tr>
	
		"""),_display_(Seq[Any](/*15.4*/ingredients/*15.15*/.map/*15.19*/ { ingredient =>_display_(Seq[Any](format.raw/*15.35*/("""
			<tr>
				<td>"""),_display_(Seq[Any](/*17.10*/ingredient/*17.20*/.amount)),format.raw/*17.27*/("""</td>
				<td>"""),_display_(Seq[Any](/*18.10*/ingredient/*18.20*/.unit)),format.raw/*18.25*/("""</td>
				<td>"""),_display_(Seq[Any](/*19.10*/ingredient/*19.20*/.name)),format.raw/*19.25*/("""</td>
				"""),_display_(Seq[Any](/*20.6*/render(ingredient)/*20.24*/.map/*20.28*/ { action =>_display_(Seq[Any](format.raw/*20.40*/("""
					<td> """),_display_(Seq[Any](/*21.12*/action)),format.raw/*21.18*/(""" </td>
				""")))})),format.raw/*22.6*/("""
			</tr>
		""")))})),format.raw/*24.4*/("""	
	</table>
	"""))}
    }
    
    def render(recipeId:Long,ingredients:List[Ingredient],render:_root_.scala.Function1[Ingredient, List[Html]]) = apply(recipeId,ingredients,render)
    
    def f:((Long,List[Ingredient],_root_.scala.Function1[Ingredient, List[Html]]) => play.api.templates.Html) = (recipeId,ingredients,render) => apply(recipeId,ingredients,render)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Dec 23 16:47:34 CET 2012
                    SOURCE: E:/Eigene Dateien/workspace-scala/essensplan/app/views/tags/recipe_ingredients_view.scala.html
                    HASH: ed11c5cb89ecb48ec33a1132ce1f3dbbbb69b492
                    MATRIX: 590->1|788->105|816->124|973->246|993->257|1006->261|1060->277|1114->295|1133->305|1162->312|1213->327|1232->337|1259->342|1310->357|1329->367|1356->372|1402->383|1429->401|1442->405|1492->417|1540->429|1568->435|1611->447|1655->460
                    LINES: 19->1|23->1|25->4|36->15|36->15|36->15|36->15|38->17|38->17|38->17|39->18|39->18|39->18|40->19|40->19|40->19|41->20|41->20|41->20|41->20|42->21|42->21|43->22|45->24
                    -- GENERATED --
                */
            