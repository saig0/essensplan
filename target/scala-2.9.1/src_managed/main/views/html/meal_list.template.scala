
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
object meal_list extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[List[MealDTO],Form[MealFilter],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(meals: List[MealDTO], mealForm: Form[MealFilter]):play.api.templates.Html = {
        _display_ {import helper._

import tags._

def /*6.2*/formatDate/*6.12*/(date: java.util.Date) = {{
	new java.text.SimpleDateFormat("yyyy-MM-dd").format(date)
}};def /*10.2*/dayOfWeek/*10.11*/(date: java.util.Date) = {{
	new java.text.SimpleDateFormat("EEEE").format(date)
}};def /*14.2*/dateMin/*14.9*/ = {{
	if(!meals.isEmpty) {
		formatDate(meals.head.date)
	} else {
		formatDate(new java.util.Date())
	}
}};def /*22.2*/dateMax/*22.9*/ = {{
	if(!meals.isEmpty) {
		formatDate(meals.reverse.head.date)
	} else {
		formatDate(new java.util.Date())
	}
}};
Seq[Any](format.raw/*1.52*/("""

"""),format.raw/*5.1*/("""
"""),format.raw/*8.2*/("""

"""),format.raw/*12.2*/("""

"""),format.raw/*20.2*/("""

"""),format.raw/*28.2*/("""

"""),_display_(Seq[Any](/*30.2*/main("Essensplan")/*30.20*/ {_display_(Seq[Any](format.raw/*30.22*/("""
	
	<h1>Essensplan</h1>
	
	<fieldset>
		<legend>Essensplan-Filter</legend>
		"""),_display_(Seq[Any](/*36.4*/form(routes.Application.mealsQuery)/*36.39*/ {_display_(Seq[Any](format.raw/*36.41*/("""	
			<table>
				<tr>
					<td>"""),_display_(Seq[Any](/*39.11*/inputDate(mealForm("from"), '_label -> "von"))),format.raw/*39.56*/("""</td>
					<td> - </td>
					<td>"""),_display_(Seq[Any](/*41.11*/inputDate(mealForm("to"), '_label -> "bis"))),format.raw/*41.54*/("""</td>
				</tr>
				<tr>
					<td><input type="submit" value="suchen" /></td>			
				</tr>
			</table>	
		""")))})),format.raw/*47.4*/("""
	</fieldset>
	<br/>
	
	<table border="1">
		<tr>
			<th>Datum</th>
			<th>Wochentag</th>
			<th>Mahlzeit</th>
		</tr>
	
		"""),_display_(Seq[Any](/*58.4*/meals/*58.9*/.map/*58.13*/ { meal =>_display_(Seq[Any](format.raw/*58.23*/("""
			<tr>
				<td>"""),_display_(Seq[Any](/*60.10*/meal/*60.14*/.date)),format.raw/*60.19*/("""</td>
				<td>"""),_display_(Seq[Any](/*61.10*/dayOfWeek(meal.date))),format.raw/*61.30*/("""</td>
				<td>"""),_display_(Seq[Any](/*62.10*/meal/*62.14*/.recipe.name)),format.raw/*62.26*/("""</td>
				<td>
					"""),_display_(Seq[Any](/*64.7*/form(routes.Application.recipe(meal.recipe.id, "all"))/*64.61*/{_display_(Seq[Any](format.raw/*64.62*/("""
						<input type='submit' value='Rezept öffnen' />
					""")))})),format.raw/*66.7*/("""				
				</td>
				<td>"""),_display_(Seq[Any](/*68.10*/form(routes.Application.mealEdit(meal.id))/*68.52*/{_display_(Seq[Any](format.raw/*68.53*/("""
						<input type='submit' value='bearbeiten' />
					""")))})),format.raw/*70.7*/("""
				</td>
				<td>"""),_display_(Seq[Any](/*72.10*/form(routes.Application.mealRemove(meal.id))/*72.54*/{_display_(Seq[Any](format.raw/*72.55*/("""
						<input type='submit' value='löschen' />
					""")))})),format.raw/*74.7*/("""
				</td>
			</tr>
		""")))})),format.raw/*77.4*/("""	
	</table>
	<br/>
	
	<table>
		<tr>
			<td>
				"""),_display_(Seq[Any](/*84.6*/form(routes.Application.mealsNewRecipe)/*84.45*/ {_display_(Seq[Any](format.raw/*84.47*/("""
					<input type="submit" value="neue Mahlzeit" />
				""")))})),format.raw/*86.6*/("""	
			</td>
		</tr>
		<tr>
			<td>
				"""),_display_(Seq[Any](/*91.6*/form(routes.Application.mealShoppingList(dateMin, dateMax))/*91.65*/ {_display_(Seq[Any](format.raw/*91.67*/("""	
					<input type="submit" value="Einkaufsliste erstellen" />
				""")))})),format.raw/*93.6*/("""
			</td>
		</tr>
	</table>
	
	
	
""")))})))}
    }
    
    def render(meals:List[MealDTO],mealForm:Form[MealFilter]) = apply(meals,mealForm)
    
    def f:((List[MealDTO],Form[MealFilter]) => play.api.templates.Html) = (meals,mealForm) => apply(meals,mealForm)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Mar 25 11:30:21 CET 2013
                    SOURCE: E:/Eigene Dateien/workspace-scala/essensplan/app/views/meal_list.scala.html
                    HASH: 87eb63d2a9c91bdadd165e330503bb7f332c1330
                    MATRIX: 533->1|674->87|692->97|794->188|812->197|908->282|923->289|1044->399|1059->406|1204->51|1232->85|1259->185|1288->279|1317->396|1346->521|1384->524|1411->542|1451->544|1564->622|1608->657|1648->659|1716->691|1783->736|1853->770|1918->813|2056->920|2215->1044|2228->1049|2241->1053|2289->1063|2343->1081|2356->1085|2383->1090|2434->1105|2476->1125|2527->1140|2540->1144|2574->1156|2630->1177|2693->1231|2732->1232|2822->1291|2882->1315|2933->1357|2972->1358|3059->1414|3115->1434|3168->1478|3207->1479|3291->1532|3345->1555|3430->1605|3478->1644|3518->1646|3606->1703|3680->1742|3748->1801|3788->1803|3887->1871
                    LINES: 19->1|24->6|24->6|26->10|26->10|28->14|28->14|34->22|34->22|41->1|43->5|44->8|46->12|48->20|50->28|52->30|52->30|52->30|58->36|58->36|58->36|61->39|61->39|63->41|63->41|69->47|80->58|80->58|80->58|80->58|82->60|82->60|82->60|83->61|83->61|84->62|84->62|84->62|86->64|86->64|86->64|88->66|90->68|90->68|90->68|92->70|94->72|94->72|94->72|96->74|99->77|106->84|106->84|106->84|108->86|113->91|113->91|113->91|115->93
                    -- GENERATED --
                */
            