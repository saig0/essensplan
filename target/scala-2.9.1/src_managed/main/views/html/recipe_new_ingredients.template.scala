
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
object recipe_new_ingredients extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Recipe,List[Ingredient],Form[Ingredient],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(recipe: Recipe, ingredients: List[Ingredient], ingredientForm: Form[Ingredient]):play.api.templates.Html = {
        _display_ {import helper._

import tags._


Seq[Any](format.raw/*1.83*/("""

"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/main("Rezepte")/*6.17*/ {_display_(Seq[Any](format.raw/*6.19*/("""
    
	"""),_display_(Seq[Any](/*8.3*/recipe_ingredients_view(recipe.id, ingredients, (ingredient: Ingredient) => {
		var l = List[Html]().toBuffer
		l += form(routes.Application.removeRecipeIngredient(recipe.id, ingredient.id)){ 
			Html("""<input type='submit' value='entfernen' />""")}
		l.toList
	}))),format.raw/*13.4*/("""
	<br/>
	
	<fieldset>
		<legend>Neue Zutat</legend>
		"""),_display_(Seq[Any](/*18.4*/form(routes.Application.addRecipeIngredient(recipe.id))/*18.59*/ {_display_(Seq[Any](format.raw/*18.61*/("""
			"""),_display_(Seq[Any](/*19.5*/inputText(ingredientForm("amount"), '_label -> "Menge"))),format.raw/*19.60*/("""
			"""),_display_(Seq[Any](/*20.5*/select(
				field = ingredientForm("unit"), 
				options = options(
					"g" -> "g",
					"kg" -> "kg",
					"ml" -> "ml",
					"l" -> "l",
					"Stück" -> "Stück",
					"Packung" -> "Packung", 
					"Bund" -> "Bund"), 
					'_label -> "Einheit"
			))),format.raw/*31.5*/("""
			"""),_display_(Seq[Any](/*32.5*/inputText(ingredientForm("name"), '_label -> "Name der Zutat"))),format.raw/*32.67*/("""
			
			<input type="submit" value="hinzufügen" />
		""")))})),format.raw/*35.4*/("""
	</fieldset>
	
	<table>
		<tr>
			<td>	
				"""),_display_(Seq[Any](/*41.6*/form(routes.Application.editRecipe(recipe.id))/*41.52*/ {_display_(Seq[Any](format.raw/*41.54*/("""
					<input type="submit" value="zurück" />
				""")))})),format.raw/*43.6*/("""
			</td>
			<td>
				"""),_display_(Seq[Any](/*46.6*/form(routes.Application.recipePreparation(recipe.id))/*46.59*/ {_display_(Seq[Any](format.raw/*46.61*/("""
					<input type="submit" value="weiter" />
				""")))})),format.raw/*48.6*/("""
			</td>
		</tr>
	</table>
""")))})))}
    }
    
    def render(recipe:Recipe,ingredients:List[Ingredient],ingredientForm:Form[Ingredient]) = apply(recipe,ingredients,ingredientForm)
    
    def f:((Recipe,List[Ingredient],Form[Ingredient]) => play.api.templates.Html) = (recipe,ingredients,ingredientForm) => apply(recipe,ingredients,ingredientForm)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Mar 27 10:57:19 CET 2013
                    SOURCE: E:/Eigene Dateien/workspace-scala/essensplan/app/views/recipe_new_ingredients.scala.html
                    HASH: db832fc00a97fceeb0067c899fcf46b75b23aa07
                    MATRIX: 556->1|745->82|773->116|809->118|832->133|871->135|913->143|1199->408|1289->463|1353->518|1393->520|1433->525|1510->580|1550->585|1821->835|1861->840|1945->902|2030->956|2111->1002|2166->1048|2206->1050|2287->1100|2345->1123|2407->1176|2447->1178|2528->1228
                    LINES: 19->1|25->1|27->5|28->6|28->6|28->6|30->8|35->13|40->18|40->18|40->18|41->19|41->19|42->20|53->31|54->32|54->32|57->35|63->41|63->41|63->41|65->43|68->46|68->46|68->46|70->48
                    -- GENERATED --
                */
            