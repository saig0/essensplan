
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
object recipe_info_view extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[RecipeDTO,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(recipe: RecipeDTO):play.api.templates.Html = {
        _display_ {import helper._


Seq[Any](format.raw/*1.21*/("""

"""),format.raw/*4.1*/("""
	
	<h2>Informationen</h2>
	
	"""),_display_(Seq[Any](/*8.3*/if(!recipe.imageRef.isEmpty)/*8.31*/ {_display_(Seq[Any](format.raw/*8.33*/("""
		<img src=""""),_display_(Seq[Any](/*9.14*/recipe/*9.20*/.imageRef)),format.raw/*9.29*/("""" alt="Bild vom Essen" width="250px"/>
	""")))})),format.raw/*10.3*/("""
	
	<table border="1">
		<tr>
			<td>Bewertung</td>
			<td>
				<input type="range" id="rating" name="rating" value=""""),_display_(Seq[Any](/*16.59*/recipe/*16.65*/.rating)),format.raw/*16.72*/("""" min="0" max="5" disabled="disabled" />
			</td>
		</tr>
		<tr>
			<td>Quelle</td>
			<td>"""),_display_(Seq[Any](/*21.9*/recipe/*21.15*/.source)),format.raw/*21.22*/("""</td>
		</tr>
		<tr>
			<td>Tags</td>
			<td>"""),_display_(Seq[Any](/*25.9*/recipe/*25.15*/.tags.map(_.name).mkString(","))),format.raw/*25.46*/("""</td>
		</tr>
	</table>
	
"""))}
    }
    
    def render(recipe:RecipeDTO) = apply(recipe)
    
    def f:((RecipeDTO) => play.api.templates.Html) = (recipe) => apply(recipe)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Mar 27 10:57:19 CET 2013
                    SOURCE: E:/Eigene Dateien/workspace-scala/essensplan/app/views/tags/recipe_info_view.scala.html
                    HASH: 32fe7e4de33a1f27fe3644c593d797c2f489bdbc
                    MATRIX: 524->1|636->20|664->39|729->70|765->98|804->100|853->114|867->120|897->129|969->170|1123->288|1138->294|1167->301|1294->393|1309->399|1338->406|1419->452|1434->458|1487->489
                    LINES: 19->1|23->1|25->4|29->8|29->8|29->8|30->9|30->9|30->9|31->10|37->16|37->16|37->16|42->21|42->21|42->21|46->25|46->25|46->25
                    -- GENERATED --
                */
            