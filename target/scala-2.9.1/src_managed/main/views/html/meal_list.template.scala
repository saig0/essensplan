
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
}};def /*10.2*/dateMin/*10.9*/ = {{
	if(!meals.isEmpty) {
		formatDate(meals.head.date)
	} else {
		formatDate(new java.util.Date())
	}
}};def /*18.2*/dateMax/*18.9*/ = {{
	if(!meals.isEmpty) {
		formatDate(meals.reverse.head.date)
	} else {
		formatDate(new java.util.Date())
	}
}};
Seq[Any](format.raw/*1.52*/("""

"""),format.raw/*5.1*/("""
"""),format.raw/*8.2*/("""

"""),format.raw/*16.2*/("""

"""),format.raw/*24.2*/("""

"""),_display_(Seq[Any](/*26.2*/main("Essensplan")/*26.20*/ {_display_(Seq[Any](format.raw/*26.22*/("""
	
	<h1>Essensplan</h1>
	
	<fieldset>
		<legend>Essensplan-Filter</legend>
		"""),_display_(Seq[Any](/*32.4*/form(routes.Application.mealsQuery)/*32.39*/ {_display_(Seq[Any](format.raw/*32.41*/("""	
			<table>
				<tr>
					<td>"""),_display_(Seq[Any](/*35.11*/inputDate(mealForm("from"), '_label -> "von"))),format.raw/*35.56*/("""</td>
					<td> - </td>
					<td>"""),_display_(Seq[Any](/*37.11*/inputDate(mealForm("to"), '_label -> "bis"))),format.raw/*37.54*/("""</td>
				</tr>
				<tr>
					<td><input type="submit" value="suchen" /></td>			
				</tr>
			</table>	
		""")))})),format.raw/*43.4*/("""
	</fieldset>
	<br/>
	
	<table border="1">
		<tr>
			<th>Datum</th>
			<th>Mahlzeit</th>
		</tr>
	
		"""),_display_(Seq[Any](/*53.4*/meals/*53.9*/.map/*53.13*/ { meal =>_display_(Seq[Any](format.raw/*53.23*/("""
			<tr>
				<td>"""),_display_(Seq[Any](/*55.10*/meal/*55.14*/.date)),format.raw/*55.19*/("""</td>
				<td>"""),_display_(Seq[Any](/*56.10*/meal/*56.14*/.recipe.name)),format.raw/*56.26*/("""</td>
				<td>
					"""),_display_(Seq[Any](/*58.7*/form(routes.Application.recipe(meal.recipe.id, "all"))/*58.61*/{_display_(Seq[Any](format.raw/*58.62*/("""
						<input type='submit' value='Rezept öffnen' />
					""")))})),format.raw/*60.7*/("""				
				</td>
				<td>"""),_display_(Seq[Any](/*62.10*/form(routes.Application.mealEdit(meal.id))/*62.52*/{_display_(Seq[Any](format.raw/*62.53*/("""
						<input type='submit' value='bearbeiten' />
					""")))})),format.raw/*64.7*/("""
				</td>
				<td>"""),_display_(Seq[Any](/*66.10*/form(routes.Application.mealRemove(meal.id))/*66.54*/{_display_(Seq[Any](format.raw/*66.55*/("""
						<input type='submit' value='löschen' />
					""")))})),format.raw/*68.7*/("""
				</td>
			</tr>
		""")))})),format.raw/*71.4*/("""	
	</table>
	<br/>
	
	<table>
		<tr>
			<td>
				"""),_display_(Seq[Any](/*78.6*/form(routes.Application.mealsNewRecipe)/*78.45*/ {_display_(Seq[Any](format.raw/*78.47*/("""
					<input type="submit" value="neue Mahlzeit" />
				""")))})),format.raw/*80.6*/("""	
			</td>
		</tr>
		<tr>
			<td>
				"""),_display_(Seq[Any](/*85.6*/form(routes.Application.mealShoppingList(dateMin, dateMax))/*85.65*/ {_display_(Seq[Any](format.raw/*85.67*/("""	
					<input type="submit" value="Einkaufsliste erstellen" />
				""")))})),format.raw/*87.6*/("""
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
                    DATE: Wed Mar 20 00:30:26 CET 2013
                    SOURCE: E:/Eigene Dateien/workspace-scala/essensplan/app/views/meal_list.scala.html
                    HASH: 50026de0fe183a86c825d5b27c67652307837d29
                    MATRIX: 533->1|674->87|692->97|794->188|809->195|930->305|945->312|1090->51|1118->85|1145->185|1174->302|1203->427|1241->430|1268->448|1308->450|1421->528|1465->563|1505->565|1573->597|1640->642|1710->676|1775->719|1913->826|2050->928|2063->933|2076->937|2124->947|2178->965|2191->969|2218->974|2269->989|2282->993|2316->1005|2372->1026|2435->1080|2474->1081|2564->1140|2624->1164|2675->1206|2714->1207|2801->1263|2857->1283|2910->1327|2949->1328|3033->1381|3087->1404|3172->1454|3220->1493|3260->1495|3348->1552|3422->1591|3490->1650|3530->1652|3629->1720
                    LINES: 19->1|24->6|24->6|26->10|26->10|32->18|32->18|39->1|41->5|42->8|44->16|46->24|48->26|48->26|48->26|54->32|54->32|54->32|57->35|57->35|59->37|59->37|65->43|75->53|75->53|75->53|75->53|77->55|77->55|77->55|78->56|78->56|78->56|80->58|80->58|80->58|82->60|84->62|84->62|84->62|86->64|88->66|88->66|88->66|90->68|93->71|100->78|100->78|100->78|102->80|107->85|107->85|107->85|109->87
                    -- GENERATED --
                */
            