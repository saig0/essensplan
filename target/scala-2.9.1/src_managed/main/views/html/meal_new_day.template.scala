
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
object meal_new_day extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Recipe,Form[NewMealFilter],Long,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(recipe: Recipe, newMealForm: Form[NewMealFilter], mealId: Long = 0):play.api.templates.Html = {
        _display_ {import helper._

import tags._


Seq[Any](format.raw/*1.70*/("""

"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/main("Essensplan")/*6.20*/ {_display_(Seq[Any](format.raw/*6.22*/("""
	
	<h1>Tag auswählen</h1>
	
	<fieldset>
		"""),_display_(Seq[Any](/*11.4*/form(
			if(mealId == 0) {
				routes.Application.mealsNew(recipe.id)
			} else {
				routes.Application.mealUpdate(recipe.id, mealId)
			}
		)/*17.4*/ {_display_(Seq[Any](format.raw/*17.6*/("""		
			"""),_display_(Seq[Any](/*18.5*/inputDate(newMealForm("date"), '_label -> "Tag für die Mahlzeit"))),format.raw/*18.70*/("""
			
			<input type='submit' value='eintragen' />
		""")))})),format.raw/*21.4*/("""	
	</fieldset>
""")))})))}
    }
    
    def render(recipe:Recipe,newMealForm:Form[NewMealFilter],mealId:Long) = apply(recipe,newMealForm,mealId)
    
    def f:((Recipe,Form[NewMealFilter],Long) => play.api.templates.Html) = (recipe,newMealForm,mealId) => apply(recipe,newMealForm,mealId)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Mar 20 00:33:48 CET 2013
                    SOURCE: E:/Eigene Dateien/workspace-scala/essensplan/app/views/meal_new_day.scala.html
                    HASH: 6a32d9596ecd71aff44f3f7c5393d7de62eb5a8f
                    MATRIX: 537->1|713->69|741->103|777->105|803->123|842->125|921->169|1072->312|1111->314|1153->321|1240->386|1324->439
                    LINES: 19->1|25->1|27->5|28->6|28->6|28->6|33->11|39->17|39->17|40->18|40->18|43->21
                    -- GENERATED --
                */
            