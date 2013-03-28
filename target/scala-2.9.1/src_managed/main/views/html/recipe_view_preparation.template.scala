
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
object recipe_view_preparation extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Long,Int,List[PreparationStep],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(recipeId: Long, step: Int, preparationSteps: List[PreparationStep]):play.api.templates.Html = {
        _display_ {import helper._


Seq[Any](format.raw/*1.70*/("""

"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/main("Rezept")/*5.16*/ {_display_(Seq[Any](format.raw/*5.18*/("""
    	
	<h2>Zubereitung - Schritt """),_display_(Seq[Any](/*7.29*/step)),format.raw/*7.33*/("""</h2>
	
	"""),_display_(Seq[Any](/*9.3*/defining(if(step <= preparationSteps.size) {
			preparationSteps(step-1)
		} else {
			PreparationStep(0,0,0,"keine Anleitung verfügbar","")
		})/*13.5*/{ preparationStep =>_display_(Seq[Any](format.raw/*13.25*/("""
	<table>
			<tr>
				<td>
					"""),_display_(Seq[Any](/*17.7*/if(!preparationStep.imageRef.isEmpty)/*17.44*/ {_display_(Seq[Any](format.raw/*17.46*/("""
						<img src=""""),_display_(Seq[Any](/*18.18*/preparationStep/*18.33*/.imageRef)),format.raw/*18.42*/("""" alt="Schritt """),_display_(Seq[Any](/*18.58*/preparationStep/*18.73*/.step)),format.raw/*18.78*/("""" width="250px"/> 
					""")))})),format.raw/*19.7*/(""" 
				</td>
			<tr>
			<tr>
				<td valign="top">"""),_display_(Seq[Any](/*23.23*/preparationStep/*23.38*/.description)),format.raw/*23.50*/("""</td>				
			</tr>
	</table>
	""")))})),format.raw/*26.3*/("""
	
	"""),_display_(Seq[Any](/*28.3*/if(step < preparationSteps.size)/*28.35*/ {_display_(Seq[Any](format.raw/*28.37*/("""
		"""),_display_(Seq[Any](/*29.4*/form(routes.RecipeController.recipe(recipeId, "step="+(step+1)))/*29.68*/ {_display_(Seq[Any](format.raw/*29.70*/("""
			<input type="submit" value="weiter" />
		""")))})),format.raw/*31.4*/("""
	""")))})),format.raw/*32.3*/("""
	
	"""),_display_(Seq[Any](/*34.3*/form(if(step == 1) {
			routes.RecipeController.recipe(recipeId, "ingredients")
		} else {
			routes.RecipeController.recipe(recipeId, "step="+(step-1))
		})/*38.5*/ {_display_(Seq[Any](format.raw/*38.7*/("""
		<input type="submit" value="zurück" />
	""")))})),format.raw/*40.3*/("""
""")))})))}
    }
    
    def render(recipeId:Long,step:Int,preparationSteps:List[PreparationStep]) = apply(recipeId,step,preparationSteps)
    
    def f:((Long,Int,List[PreparationStep]) => play.api.templates.Html) = (recipeId,step,preparationSteps) => apply(recipeId,step,preparationSteps)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Mar 28 12:16:21 CET 2013
                    SOURCE: E:/Eigene Dateien/workspace-scala/essensplan/app/views/recipe_view_preparation.scala.html
                    HASH: c98a971d9a49a64596418dd5e8f963cb14616541
                    MATRIX: 547->1|708->69|736->88|772->90|794->104|833->106|903->141|928->145|972->155|1125->300|1183->320|1251->353|1297->390|1337->392|1391->410|1415->425|1446->434|1498->450|1522->465|1549->470|1605->495|1691->545|1715->560|1749->572|1811->603|1851->608|1892->640|1932->642|1971->646|2044->710|2084->712|2161->758|2195->761|2235->766|2400->923|2439->925|2514->969
                    LINES: 19->1|23->1|25->4|26->5|26->5|26->5|28->7|28->7|30->9|34->13|34->13|38->17|38->17|38->17|39->18|39->18|39->18|39->18|39->18|39->18|40->19|44->23|44->23|44->23|47->26|49->28|49->28|49->28|50->29|50->29|50->29|52->31|53->32|55->34|59->38|59->38|61->40
                    -- GENERATED --
                */
            