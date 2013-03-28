
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

def /*6.2*/locale/*6.8*/ = {{ java.util.Locale.GERMAN }};def /*8.2*/formatDate/*8.12*/(date: java.util.Date) = {{
	new java.text.SimpleDateFormat("dd.MM.yyyy").format(date)
}};def /*12.2*/dayOfWeek/*12.11*/(date: java.util.Date) = {{
	new java.text.SimpleDateFormat("EEEE",locale).format(date)
}};def /*16.2*/dateMin/*16.9*/ = {{
	if(!meals.isEmpty) {
		formatDate(meals.head.date)
	} else {
		formatDate(new java.util.Date())
	}
}};def /*24.2*/dateMax/*24.9*/ = {{
	if(!meals.isEmpty) {
		formatDate(meals.reverse.head.date)
	} else {
		formatDate(new java.util.Date())
	}
}};
Seq[Any](format.raw/*1.52*/("""

"""),format.raw/*5.1*/("""
"""),format.raw/*6.39*/("""

"""),format.raw/*10.2*/("""

"""),format.raw/*14.2*/("""

"""),format.raw/*22.2*/("""

"""),format.raw/*30.2*/("""

"""),_display_(Seq[Any](/*32.2*/main("Essensplan")/*32.20*/ {_display_(Seq[Any](format.raw/*32.22*/("""
	
	<h1>Essensplan</h1>
	
	<fieldset>
		<legend>Essensplan-Filter</legend>
		"""),_display_(Seq[Any](/*38.4*/form(routes.MealController.mealsQuery)/*38.42*/ {_display_(Seq[Any](format.raw/*38.44*/("""	
			<table>
				<tr>
					<td>"""),_display_(Seq[Any](/*41.11*/inputDate(mealForm("from"), '_label -> "von"))),format.raw/*41.56*/("""</td>
					<td> - </td>
					<td>"""),_display_(Seq[Any](/*43.11*/inputDate(mealForm("to"), '_label -> "bis"))),format.raw/*43.54*/("""</td>
				</tr>
				<tr>
					<td><input type="submit" value="suchen" /></td>			
				</tr>
			</table>	
		""")))})),format.raw/*49.4*/("""
	</fieldset>
	<br/>
	
	<table border="1">
		<tr>
			<th>Datum</th>
			<th>Wochentag</th>
			<th>Mahlzeit</th>
		</tr>
	
		"""),_display_(Seq[Any](/*60.4*/meals/*60.9*/.map/*60.13*/ { meal =>_display_(Seq[Any](format.raw/*60.23*/("""
			<tr>
				<td>"""),_display_(Seq[Any](/*62.10*/formatDate(meal.date))),format.raw/*62.31*/("""</td>
				<td>"""),_display_(Seq[Any](/*63.10*/dayOfWeek(meal.date))),format.raw/*63.30*/("""</td>
				<td>"""),_display_(Seq[Any](/*64.10*/meal/*64.14*/.recipe.name)),format.raw/*64.26*/("""</td>
				<td>
					"""),_display_(Seq[Any](/*66.7*/form(routes.RecipeController.recipe(meal.recipe.id, "all"))/*66.66*/{_display_(Seq[Any](format.raw/*66.67*/("""
						<input type='submit' value='Rezept öffnen' />
					""")))})),format.raw/*68.7*/("""				
				</td>
				<td>"""),_display_(Seq[Any](/*70.10*/form(routes.MealController.mealEdit(meal.id))/*70.55*/{_display_(Seq[Any](format.raw/*70.56*/("""
						<input type='submit' value='bearbeiten' />
					""")))})),format.raw/*72.7*/("""
				</td>
				<td>"""),_display_(Seq[Any](/*74.10*/form(routes.MealController.mealRemove(meal.id))/*74.57*/{_display_(Seq[Any](format.raw/*74.58*/("""
						<input type='submit' value='löschen' />
					""")))})),format.raw/*76.7*/("""
				</td>
			</tr>
		""")))})),format.raw/*79.4*/("""	
	</table>
	<br/>
	
	<table>
		<tr>
			<td>
				"""),_display_(Seq[Any](/*86.6*/form(routes.MealController.mealsNewRecipe)/*86.48*/ {_display_(Seq[Any](format.raw/*86.50*/("""
					<input type="submit" value="neue Mahlzeit" />
				""")))})),format.raw/*88.6*/("""	
			</td>
		</tr>
		<tr>
			<td>
				"""),_display_(Seq[Any](/*93.6*/form(routes.MealController.mealShoppingList(dateMin, dateMax))/*93.68*/ {_display_(Seq[Any](format.raw/*93.70*/("""	
					<input type="submit" value="Einkaufsliste erstellen" />
				""")))})),format.raw/*95.6*/("""
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
                    DATE: Thu Mar 28 12:13:13 CET 2013
                    SOURCE: E:/Eigene Dateien/workspace-scala/essensplan/app/views/meal_list.scala.html
                    HASH: f0b2277466f3903322b5b0ede9a2afdeb9f7d71c
                    MATRIX: 533->1|674->87|687->93|731->127|749->137|851->228|869->237|972->329|987->336|1108->446|1123->453|1268->51|1296->85|1324->124|1353->225|1382->326|1411->443|1440->568|1478->571|1505->589|1545->591|1658->669|1705->707|1745->709|1813->741|1880->786|1950->820|2015->863|2153->970|2312->1094|2325->1099|2338->1103|2386->1113|2440->1131|2483->1152|2534->1167|2576->1187|2627->1202|2640->1206|2674->1218|2730->1239|2798->1298|2837->1299|2927->1358|2987->1382|3041->1427|3080->1428|3167->1484|3223->1504|3279->1551|3318->1552|3402->1605|3456->1628|3541->1678|3592->1720|3632->1722|3720->1779|3794->1818|3865->1880|3905->1882|4004->1950
                    LINES: 19->1|24->6|24->6|24->8|24->8|26->12|26->12|28->16|28->16|34->24|34->24|41->1|43->5|44->6|46->10|48->14|50->22|52->30|54->32|54->32|54->32|60->38|60->38|60->38|63->41|63->41|65->43|65->43|71->49|82->60|82->60|82->60|82->60|84->62|84->62|85->63|85->63|86->64|86->64|86->64|88->66|88->66|88->66|90->68|92->70|92->70|92->70|94->72|96->74|96->74|96->74|98->76|101->79|108->86|108->86|108->86|110->88|115->93|115->93|115->93|117->95
                    -- GENERATED --
                */
            