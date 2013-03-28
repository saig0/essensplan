
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
object recipe_new_preparation extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Recipe,List[PreparationStep],Form[PreparationStep],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(recipe: Recipe, preparationSteps: List[PreparationStep], preparationStepForm: Form[PreparationStep]):play.api.templates.Html = {
        _display_ {import helper._


Seq[Any](format.raw/*1.103*/("""

"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/main("Rezepte")/*5.17*/ {_display_(Seq[Any](format.raw/*5.19*/("""
    
	<h1>Zubereitung</h1>
	
	<table border="1">
		<tr>
			<th>Schritt</th>
			<th>Beschreibung</th>
			<th>Bild</th>
			<td> </th>
		</tr>
	
		"""),_display_(Seq[Any](/*17.4*/preparationSteps/*17.20*/.map/*17.24*/ { preparationStep =>_display_(Seq[Any](format.raw/*17.45*/("""
			<tr>
				<td valign="top">"""),_display_(Seq[Any](/*19.23*/preparationStep/*19.38*/.step)),format.raw/*19.43*/("""</td>
				<td valign="top">"""),_display_(Seq[Any](/*20.23*/preparationStep/*20.38*/.description)),format.raw/*20.50*/("""</td>
				<td>
					"""),_display_(Seq[Any](/*22.7*/if(!preparationStep.imageRef.isEmpty)/*22.44*/ {_display_(Seq[Any](format.raw/*22.46*/("""
						<img src=""""),_display_(Seq[Any](/*23.18*/preparationStep/*23.33*/.imageRef)),format.raw/*23.42*/("""" alt="Schritt """),_display_(Seq[Any](/*23.58*/preparationStep/*23.73*/.step)),format.raw/*23.78*/("""" width="250px"/> 
					""")))})),format.raw/*24.7*/(""" 
				</td>
				<td valign="top">
					"""),_display_(Seq[Any](/*27.7*/if(preparationStep.step == preparationSteps.size)/*27.56*/ {_display_(Seq[Any](format.raw/*27.58*/("""
						"""),_display_(Seq[Any](/*28.8*/form(routes.RecipeCreator.removePreparationStep(recipe.id, preparationStep.id))/*28.87*/ {_display_(Seq[Any](format.raw/*28.89*/("""
							<input type="submit" value="entfernen" />
						""")))})),format.raw/*30.8*/("""
					""")))})),format.raw/*31.7*/("""
				</td>
			</tr>
		""")))})),format.raw/*34.4*/("""	
	</table>
	</br>
	
	<fieldset>
		<legend>Neuer Zubereitungsschritt</legend>
		"""),_display_(Seq[Any](/*40.4*/form(routes.RecipeCreator.addPreparationStep(recipe.id))/*40.60*/ {_display_(Seq[Any](format.raw/*40.62*/("""
			<input type="hidden" name="step" value=""""),_display_(Seq[Any](/*41.45*/(preparationSteps.size + 1))),format.raw/*41.72*/("""" />
			"""),_display_(Seq[Any](/*42.5*/textarea(preparationStepForm("description"), '_label -> "Anleitung"))),format.raw/*42.73*/("""
			"""),_display_(Seq[Any](/*43.5*/inputText(preparationStepForm("imageRef"), '_label -> "Link zu einem Bild"))),format.raw/*43.80*/("""
			
			<input type="submit" value="hinzufügen" />
		""")))})),format.raw/*46.4*/("""
	</fieldset>
	
	<table>
		<tr>
			<td>	
				"""),_display_(Seq[Any](/*52.6*/form(routes.RecipeCreator.recipeIngredients(recipe.id))/*52.61*/ {_display_(Seq[Any](format.raw/*52.63*/("""
					<input type="submit" value="zurück" />
				""")))})),format.raw/*54.6*/("""	
			</td>
			<td>
				"""),_display_(Seq[Any](/*57.6*/form(routes.RecipeController.recipes)/*57.43*/ {_display_(Seq[Any](format.raw/*57.45*/("""
					<input type="submit" value="fertig" />
				""")))})),format.raw/*59.6*/("""
			</td>
		</tr>
	</table>	
""")))})))}
    }
    
    def render(recipe:Recipe,preparationSteps:List[PreparationStep],preparationStepForm:Form[PreparationStep]) = apply(recipe,preparationSteps,preparationStepForm)
    
    def f:((Recipe,List[PreparationStep],Form[PreparationStep]) => play.api.templates.Html) = (recipe,preparationSteps,preparationStepForm) => apply(recipe,preparationSteps,preparationStepForm)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Mar 28 12:15:24 CET 2013
                    SOURCE: E:/Eigene Dateien/workspace-scala/essensplan/app/views/recipe_new_preparation.scala.html
                    HASH: 414fd7188660dc35873f2b4ad46d7652322b311a
                    MATRIX: 566->1|761->102|789->121|825->123|848->138|887->140|1068->286|1093->302|1106->306|1165->327|1232->358|1256->373|1283->378|1347->406|1371->421|1405->433|1461->454|1507->491|1547->493|1601->511|1625->526|1656->535|1708->551|1732->566|1759->571|1815->596|1890->636|1948->685|1988->687|2031->695|2119->774|2159->776|2247->833|2285->840|2339->863|2455->944|2520->1000|2560->1002|2641->1047|2690->1074|2734->1083|2824->1151|2864->1156|2961->1231|3046->1285|3127->1331|3191->1386|3231->1388|3312->1438|3371->1462|3417->1499|3457->1501|3538->1551
                    LINES: 19->1|23->1|25->4|26->5|26->5|26->5|38->17|38->17|38->17|38->17|40->19|40->19|40->19|41->20|41->20|41->20|43->22|43->22|43->22|44->23|44->23|44->23|44->23|44->23|44->23|45->24|48->27|48->27|48->27|49->28|49->28|49->28|51->30|52->31|55->34|61->40|61->40|61->40|62->41|62->41|63->42|63->42|64->43|64->43|67->46|73->52|73->52|73->52|75->54|78->57|78->57|78->57|80->59
                    -- GENERATED --
                */
            