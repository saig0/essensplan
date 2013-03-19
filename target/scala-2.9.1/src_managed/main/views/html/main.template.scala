
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
object main extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,Html,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(title: String)(content: Html):play.api.templates.Html = {
        _display_ {import helper._


Seq[Any](format.raw/*1.32*/("""

"""),format.raw/*4.1*/("""
<!DOCTYPE html>

<html>
    <head>
        <title>"""),_display_(Seq[Any](/*9.17*/title)),format.raw/*9.22*/("""</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*10.54*/routes/*10.60*/.Assets.at("stylesheets/main.css"))),format.raw/*10.94*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*11.59*/routes/*11.65*/.Assets.at("images/favicon.png"))),format.raw/*11.97*/("""">
        <script src=""""),_display_(Seq[Any](/*12.23*/routes/*12.29*/.Assets.at("javascripts/jquery-1.7.1.min.js"))),format.raw/*12.74*/("""" type="text/javascript"></script>
    </head>
    <body>
	
		<nav>
			<a href="/recipes">Rezepte</a> |
			<a href="/meals">Essensplan</a> |
			Einkaufsliste 
		</nav>
    
		<table>
			<tr>
				<td>
					"""),_display_(Seq[Any](/*25.7*/form(routes.Application.login)/*25.37*/ {_display_(Seq[Any](format.raw/*25.39*/("""
						<input type="submit" value="Login" />
					""")))})),format.raw/*27.7*/("""
				</td>
				<td>
					"""),_display_(Seq[Any](/*30.7*/form(routes.Application.logout)/*30.38*/ {_display_(Seq[Any](format.raw/*30.40*/("""
						<input type="submit" value="Logout" />
					""")))})),format.raw/*32.7*/("""
				</td>
			</tr>
		</table>

		"""),_display_(Seq[Any](/*37.4*/content)),format.raw/*37.11*/("""
    </body>
</html>
"""))}
    }
    
    def render(title:String,content:Html) = apply(title)(content)
    
    def f:((String) => (Html) => play.api.templates.Html) = (title) => (content) => apply(title)(content)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Mar 16 01:11:49 CET 2013
                    SOURCE: E:/Eigene Dateien/workspace-scala/essensplan/app/views/main.scala.html
                    HASH: 8fc5c46da2654fb7e9ef012f2fbc519df3c6c30e
                    MATRIX: 509->1|632->31|660->50|747->102|773->107|871->169|886->175|942->209|1039->270|1054->276|1108->308|1169->333|1184->339|1251->384|1492->590|1531->620|1571->622|1653->673|1714->699|1754->730|1794->732|1877->784|1947->819|1976->826
                    LINES: 19->1|23->1|25->4|30->9|30->9|31->10|31->10|31->10|32->11|32->11|32->11|33->12|33->12|33->12|46->25|46->25|46->25|48->27|51->30|51->30|51->30|53->32|58->37|58->37
                    -- GENERATED --
                */
            