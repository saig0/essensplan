
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
object recipe_view extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[RecipeDTO,List[Ingredient],List[PreparationStep],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(recipe: RecipeDTO, ingredients: List[Ingredient], preparationSteps: List[PreparationStep]):play.api.templates.Html = {
        _display_ {import helper._

import tags._


Seq[Any](format.raw/*1.93*/("""

"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/main("Rezept")/*6.16*/ {_display_(Seq[Any](format.raw/*6.18*/("""
    
	<h1>Rezept: """),_display_(Seq[Any](/*8.15*/recipe/*8.21*/.name)),format.raw/*8.26*/("""</h1>
	
	"""),_display_(Seq[Any](/*10.3*/form(routes.Application.recipe(recipe.id, "info"))/*10.53*/ {_display_(Seq[Any](format.raw/*10.55*/("""
		<input type="submit" value="Schritt-für-Schritt-Anleitung" />
	""")))})),format.raw/*12.3*/("""
	
	"""),_display_(Seq[Any](/*14.3*/recipe_info_view(recipe))),format.raw/*14.27*/("""
	
	"""),_display_(Seq[Any](/*16.3*/recipe_ingredients_view(recipe.id, ingredients))),format.raw/*16.50*/("""
	
	<h2>Zubereitung</h2>
	
	<table border="1">
		<tr>
			<th>Schritt</th>
			<th>Beschreibung</th>
			<th>Bild</th>
		</tr>
	
		"""),_display_(Seq[Any](/*27.4*/preparationSteps/*27.20*/.map/*27.24*/ { preparationStep =>_display_(Seq[Any](format.raw/*27.45*/("""
			<tr>
				<td valign="top">"""),_display_(Seq[Any](/*29.23*/preparationStep/*29.38*/.step)),format.raw/*29.43*/("""</td>
				<td valign="top">"""),_display_(Seq[Any](/*30.23*/preparationStep/*30.38*/.description)),format.raw/*30.50*/("""</td>
				<td>
					"""),_display_(Seq[Any](/*32.7*/if(!preparationStep.imageRef.isEmpty)/*32.44*/ {_display_(Seq[Any](format.raw/*32.46*/("""
						<img src=""""),_display_(Seq[Any](/*33.18*/preparationStep/*33.33*/.imageRef)),format.raw/*33.42*/("""" alt="Schritt """),_display_(Seq[Any](/*33.58*/preparationStep/*33.73*/.step)),format.raw/*33.78*/("""" width="250px"/> 
					""")))})),format.raw/*34.7*/(""" 
				</td>
			</tr>
		""")))})),format.raw/*37.4*/("""	
	</table>
""")))})))}
    }
    
    def render(recipe:RecipeDTO,ingredients:List[Ingredient],preparationSteps:List[PreparationStep]) = apply(recipe,ingredients,preparationSteps)
    
    def f:((RecipeDTO,List[Ingredient],List[PreparationStep]) => play.api.templates.Html) = (recipe,ingredients,preparationSteps) => apply(recipe,ingredients,preparationSteps)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Jan 11 00:40:26 CET 2013
                    SOURCE: E:/Eigene Dateien/workspace-scala/essensplan/app/views/recipe_view.scala.html
                    HASH: 1de7f8b6cc0e5706cbcc237a3bd51f60b05dcd92
                    MATRIX: 553->1|752->92|780->126|816->128|838->142|877->144|932->164|946->170|972->175|1017->185|1076->235|1116->237|1214->304|1254->309|1300->333|1340->338|1409->385|1573->514|1598->530|1611->534|1670->555|1737->586|1761->601|1788->606|1852->634|1876->649|1910->661|1966->682|2012->719|2052->721|2106->739|2130->754|2161->763|2213->779|2237->794|2264->799|2320->824|2375->848
                    LINES: 19->1|25->1|27->5|28->6|28->6|28->6|30->8|30->8|30->8|32->10|32->10|32->10|34->12|36->14|36->14|38->16|38->16|49->27|49->27|49->27|49->27|51->29|51->29|51->29|52->30|52->30|52->30|54->32|54->32|54->32|55->33|55->33|55->33|55->33|55->33|55->33|56->34|59->37
                    -- GENERATED --
                */
            