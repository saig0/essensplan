
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
object recipe_list_view extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template6[List[Recipe],Form[RecipeFilter],Map[String, String],play.api.mvc.Call,_root_.scala.Function1[Recipe, List[Html]],String,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(recipes: List[Recipe], searchForm: Form[RecipeFilter], tags: Map[String, String], action: play.api.mvc.Call, render: Recipe => List[Html])(titel: String = "Rezepte"):play.api.templates.Html = {
        _display_ {import helper._


Seq[Any](format.raw/*1.168*/("""

"""),format.raw/*4.1*/("""    
	<h1>"""),_display_(Seq[Any](/*5.7*/titel)),format.raw/*5.12*/("""</h1>	
	
	<fieldset>
		<legend>Rezept-Filter</legend>
		"""),_display_(Seq[Any](/*9.4*/form(action)/*9.16*/ {_display_(Seq[Any](format.raw/*9.18*/("""
			"""),_display_(Seq[Any](/*10.5*/searchInput(searchForm("name"), '_label -> "Name des Rezepts"))),format.raw/*10.67*/("""
			"""),_display_(Seq[Any](/*11.5*/select(
				field = searchForm("sorting"), 
				options = options(
					"2"		-> "name",
					"-3"	-> "rating"
				),
				'_label -> "Sortierung nach"
			))),format.raw/*18.5*/("""
			
			<details>
				<summary>erweiterte Suche</summary>
				"""),_display_(Seq[Any](/*22.6*/select(field = searchForm("tag"), 
					options = options(tags),
					'_default -> "alle Tags",
					'_label -> "Stichwörter"
				))),format.raw/*26.6*/("""
				"""),_display_(Seq[Any](/*27.6*/inputRange(searchForm("rating"), 0, 5, '_label -> "Bewertung"))),format.raw/*27.68*/("""
				"""),_display_(Seq[Any](/*28.6*/searchInput(searchForm("ingredient"), '_label -> "Enthaltene Zutat"))),format.raw/*28.74*/("""
				"""),_display_(Seq[Any](/*29.6*/checkbox(searchForm("onlyMyRecipes"), '_label -> "Nur eigene Rezepte"))),format.raw/*29.76*/("""
				<input type="hidden" name="userId" value='"""),_display_(Seq[Any](/*30.48*/searchForm("userId")/*30.68*/.value)),format.raw/*30.74*/("""' />
			</details>
		
		<input type="submit" value="suchen" />
	""")))})),format.raw/*34.3*/("""	
	</fieldset>
	<br/>
	
	<span>"""),_display_(Seq[Any](/*38.9*/recipes/*38.16*/.size)),format.raw/*38.21*/(""" Rezept"""),_display_(Seq[Any](/*38.29*/{if(recipes.size > 1) "e"})),format.raw/*38.55*/(""" gefunden</span>
	
	<table border="1">
		<tr>
			<th>Rezept</th>
		</tr>
	
		"""),_display_(Seq[Any](/*45.4*/recipes/*45.11*/.map/*45.15*/ { recipe =>_display_(Seq[Any](format.raw/*45.27*/("""
			<tr>
				<td>"""),_display_(Seq[Any](/*47.10*/recipe/*47.16*/.name)),format.raw/*47.21*/("""</td>
				"""),_display_(Seq[Any](/*48.6*/render(recipe)/*48.20*/.map/*48.24*/ { r =>_display_(Seq[Any](format.raw/*48.31*/("""
					<td> """),_display_(Seq[Any](/*49.12*/r)),format.raw/*49.13*/(""" </td>
				""")))})),format.raw/*50.6*/("""
			</tr>
		""")))})),format.raw/*52.4*/("""	
	</table>
	<br/>
	"""))}
    }
    
    def render(recipes:List[Recipe],searchForm:Form[RecipeFilter],tags:Map[String, String],action:play.api.mvc.Call,render:_root_.scala.Function1[Recipe, List[Html]],titel:String) = apply(recipes,searchForm,tags,action,render)(titel)
    
    def f:((List[Recipe],Form[RecipeFilter],Map[String, String],play.api.mvc.Call,_root_.scala.Function1[Recipe, List[Html]]) => (String) => play.api.templates.Html) = (recipes,searchForm,tags,action,render) => (titel) => apply(recipes,searchForm,tags,action,render)(titel)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Mar 27 10:57:19 CET 2013
                    SOURCE: E:/Eigene Dateien/workspace-scala/essensplan/app/views/tags/recipe_list_view.scala.html
                    HASH: a11e1cd0dd41dd15cbc934d17f20792cfdeae759
                    MATRIX: 634->1|894->167|922->186|967->197|993->202|1084->259|1104->271|1143->273|1183->278|1267->340|1307->345|1482->499|1580->562|1732->693|1773->699|1857->761|1898->767|1988->835|2029->841|2121->911|2205->959|2234->979|2262->985|2358->1050|2425->1082|2441->1089|2468->1094|2512->1102|2560->1128|2673->1206|2689->1213|2702->1217|2752->1229|2806->1247|2821->1253|2848->1258|2894->1269|2917->1283|2930->1287|2975->1294|3023->1306|3046->1307|3089->1319|3133->1332
                    LINES: 19->1|23->1|25->4|26->5|26->5|30->9|30->9|30->9|31->10|31->10|32->11|39->18|43->22|47->26|48->27|48->27|49->28|49->28|50->29|50->29|51->30|51->30|51->30|55->34|59->38|59->38|59->38|59->38|59->38|66->45|66->45|66->45|66->45|68->47|68->47|68->47|69->48|69->48|69->48|69->48|70->49|70->49|71->50|73->52
                    -- GENERATED --
                */
            