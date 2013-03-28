
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
	
	<table>
		<tr>
			<td>
				"""),_display_(Seq[Any](/*13.6*/form(routes.RecipeController.recipe(recipe.id, "info"))/*13.61*/ {_display_(Seq[Any](format.raw/*13.63*/("""
					<input type="submit" value="Schritt-für-Schritt-Anleitung" />
				""")))})),format.raw/*15.6*/("""
			</td>
			<td>
				"""),_display_(Seq[Any](/*18.6*/form(routes.RecipeCreator.editRecipe(recipe.id))/*18.54*/ {_display_(Seq[Any](format.raw/*18.56*/("""
					<input type="submit" value="bearbeiten" />
				""")))})),format.raw/*20.6*/("""
			</td>
		</tr>
	<table>
	
	"""),_display_(Seq[Any](/*25.3*/recipe_info_view(recipe))),format.raw/*25.27*/("""
	
	"""),_display_(Seq[Any](/*27.3*/recipe_ingredients_view(recipe.id, ingredients))),format.raw/*27.50*/("""
	
	<h2>Zubereitung</h2>
	
	<table border="1">
		<tr>
			<th>Schritt</th>
			<th>Beschreibung</th>
			<th>Bild</th>
		</tr>
	
		"""),_display_(Seq[Any](/*38.4*/preparationSteps/*38.20*/.map/*38.24*/ { preparationStep =>_display_(Seq[Any](format.raw/*38.45*/("""
			<tr>
				<td valign="top">"""),_display_(Seq[Any](/*40.23*/preparationStep/*40.38*/.step)),format.raw/*40.43*/("""</td>
				<td valign="top">"""),_display_(Seq[Any](/*41.23*/preparationStep/*41.38*/.description)),format.raw/*41.50*/("""</td>
				<td>
					"""),_display_(Seq[Any](/*43.7*/if(!preparationStep.imageRef.isEmpty)/*43.44*/ {_display_(Seq[Any](format.raw/*43.46*/("""
						<img src=""""),_display_(Seq[Any](/*44.18*/preparationStep/*44.33*/.imageRef)),format.raw/*44.42*/("""" alt="Schritt """),_display_(Seq[Any](/*44.58*/preparationStep/*44.73*/.step)),format.raw/*44.78*/("""" width="250px"/> 
					""")))})),format.raw/*45.7*/(""" 
				</td>
			</tr>
		""")))})),format.raw/*48.4*/("""	
	</table>
""")))})))}
    }
    
    def render(recipe:RecipeDTO,ingredients:List[Ingredient],preparationSteps:List[PreparationStep]) = apply(recipe,ingredients,preparationSteps)
    
    def f:((RecipeDTO,List[Ingredient],List[PreparationStep]) => play.api.templates.Html) = (recipe,ingredients,preparationSteps) => apply(recipe,ingredients,preparationSteps)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Mar 28 12:16:39 CET 2013
                    SOURCE: E:/Eigene Dateien/workspace-scala/essensplan/app/views/recipe_view.scala.html
                    HASH: d524d309e181d86fa095b5040cfb5e910e96d25e
                    MATRIX: 553->1|752->92|780->126|816->128|838->142|877->144|932->164|946->170|972->175|1044->212|1108->267|1148->269|1252->342|1310->365|1367->413|1407->415|1492->469|1558->500|1604->524|1644->529|1713->576|1877->705|1902->721|1915->725|1974->746|2041->777|2065->792|2092->797|2156->825|2180->840|2214->852|2270->873|2316->910|2356->912|2410->930|2434->945|2465->954|2517->970|2541->985|2568->990|2624->1015|2679->1039
                    LINES: 19->1|25->1|27->5|28->6|28->6|28->6|30->8|30->8|30->8|35->13|35->13|35->13|37->15|40->18|40->18|40->18|42->20|47->25|47->25|49->27|49->27|60->38|60->38|60->38|60->38|62->40|62->40|62->40|63->41|63->41|63->41|65->43|65->43|65->43|66->44|66->44|66->44|66->44|66->44|66->44|67->45|70->48
                    -- GENERATED --
                */
            