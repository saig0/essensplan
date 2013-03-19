
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
object meal_new_recipe extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[List[Recipe],Form[RecipeFilter],Map[String, String],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(recipes: List[Recipe], searchForm: Form[RecipeFilter], tagOptions: Map[String, String]):play.api.templates.Html = {
        _display_ {import helper._

import tags._


Seq[Any](format.raw/*1.90*/("""

"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/main("Essensplan")/*6.20*/ {_display_(Seq[Any](format.raw/*6.22*/("""
	
	"""),_display_(Seq[Any](/*8.3*/recipe_list_view(recipes, searchForm, tagOptions, routes.Application.mealsNewRecipeQuery, (recipe: Recipe) => {
		var l = List[Html]().toBuffer
		l += form(routes.Application.recipe(recipe.id, "all")) { Html("""
						<input type='submit' value='öffnen' />
						""")}
		l+=	form(routes.Application.mealsNewDay(recipe.id)) { Html("""
						<input type='submit' value='auswählen' />
					""")}
		l.toList
	})("Rezept auswählen"))),format.raw/*17.24*/("""
	
""")))})))}
    }
    
    def render(recipes:List[Recipe],searchForm:Form[RecipeFilter],tagOptions:Map[String, String]) = apply(recipes,searchForm,tagOptions)
    
    def f:((List[Recipe],Form[RecipeFilter],Map[String, String]) => play.api.templates.Html) = (recipes,searchForm,tagOptions) => apply(recipes,searchForm,tagOptions)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Jan 22 21:53:50 CET 2013
                    SOURCE: E:/Eigene Dateien/workspace-scala/essensplan/app/views/meal_new_recipe.scala.html
                    HASH: 1bb60d070ed92d30532615a445953423f538c876
                    MATRIX: 560->1|756->89|784->123|820->125|846->143|885->145|924->150|1373->577
                    LINES: 19->1|25->1|27->5|28->6|28->6|28->6|30->8|39->17
                    -- GENERATED --
                */
            