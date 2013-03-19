
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
object recipe_list extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[List[Recipe],Form[RecipeFilter],Map[String, String],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(recipes: List[Recipe], searchForm: Form[RecipeFilter], tagOptions: Map[String, String]):play.api.templates.Html = {
        _display_ {import helper._

import tags._


Seq[Any](format.raw/*1.90*/("""

"""),format.raw/*5.1*/("""

"""),_display_(Seq[Any](/*7.2*/main("Rezepte")/*7.17*/ {_display_(Seq[Any](format.raw/*7.19*/("""
	
	"""),_display_(Seq[Any](/*9.3*/recipe_list_view(recipes, searchForm, tagOptions, routes.Application.recipesQuery, (recipe: Recipe) => {
		var l = List[Html]().toBuffer
		l += form(routes.Application.recipe(recipe.id, "all")) { Html("""
						<input type='submit' value='öffnen' />
						""")}
		l+=	form(routes.Application.editRecipe(recipe.id)) { Html("""
						<input type='submit' value='bearbeiten' />
					""")}
		l+=	form(routes.Application.removeRecipe(recipe.id)) { Html("""
						<input type='submit' value='entfernen' />
					""")}
		l.toList
	})("Rezepte"))),format.raw/*21.15*/("""
	
	<table>
		<tr>
			<td>
				"""),_display_(Seq[Any](/*26.6*/form(routes.Application.newRecipe)/*26.40*/ {_display_(Seq[Any](format.raw/*26.42*/("""
					<input type="submit" value="neues Rezept" />
				""")))})),format.raw/*28.6*/("""	
			</td>
		</tr>
		<tr>
			<td>
				"""),_display_(Seq[Any](/*33.6*/form(routes.Application.importRecipe)/*33.43*/ {_display_(Seq[Any](format.raw/*33.45*/("""
					<input type="submit" value="Rezept importieren" />
				""")))})),format.raw/*35.6*/("""
			</td>
		</tr>
		<tr>
			<td>
				"""),_display_(Seq[Any](/*40.6*/form(routes.Application.tags)/*40.35*/ {_display_(Seq[Any](format.raw/*40.37*/("""
					<input type="submit" value="Stichwörter verwalten" />
				""")))})),format.raw/*42.6*/("""
			</td>
		</tr>
	</table>
""")))})))}
    }
    
    def render(recipes:List[Recipe],searchForm:Form[RecipeFilter],tagOptions:Map[String, String]) = apply(recipes,searchForm,tagOptions)
    
    def f:((List[Recipe],Form[RecipeFilter],Map[String, String]) => play.api.templates.Html) = (recipes,searchForm,tagOptions) => apply(recipes,searchForm,tagOptions)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Mar 20 00:00:17 CET 2013
                    SOURCE: E:/Eigene Dateien/workspace-scala/essensplan/app/views/recipe_list.scala.html
                    HASH: 2b1a2a27d5db445b1510d12d3ddca11aec1d835a
                    MATRIX: 556->1|752->89|780->123|817->126|840->141|879->143|918->148|1476->684|1543->716|1586->750|1626->752|1713->808|1787->847|1833->884|1873->886|1966->948|2039->986|2077->1015|2117->1017|2213->1082
                    LINES: 19->1|25->1|27->5|29->7|29->7|29->7|31->9|43->21|48->26|48->26|48->26|50->28|55->33|55->33|55->33|57->35|62->40|62->40|62->40|64->42
                    -- GENERATED --
                */
            