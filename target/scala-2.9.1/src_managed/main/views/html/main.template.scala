
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
"""),format.raw/*3.1*/("""
<!DOCTYPE html>

<html>
    <head>
        <title>Essensplan - """),_display_(Seq[Any](/*8.30*/title)),format.raw/*8.35*/("""</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*9.54*/routes/*9.60*/.Assets.at("stylesheets/main.css"))),format.raw/*9.94*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*10.59*/routes/*10.65*/.Assets.at("images/favicon.png"))),format.raw/*10.97*/("""">
        <script src=""""),_display_(Seq[Any](/*11.23*/routes/*11.29*/.Assets.at("javascripts/jquery-1.7.1.min.js"))),format.raw/*11.74*/("""" type="text/javascript"></script>
    </head>
    <body>
	
		<nav>	
			<table border="0" frame="vsides" rules="cols" cellpadding="5" width="100%">
				<tr> 
					<td width="50px">
						<a href="/recipes">Rezepte</a> 
					</td>
					<td width="50px">
						<a href="/meals">Essensplan</a>
					</td>
					<td align="right">
						"""),_display_(Seq[Any](/*25.8*/form(routes.AuthenticationController.logout)/*25.52*/ {_display_(Seq[Any](format.raw/*25.54*/("""
							<input type="submit" value="Abmelden" />
						""")))})),format.raw/*27.8*/("""
					</td>
				</tr>
			</table>
		</nav>	

		<hr/>

		"""),_display_(Seq[Any](/*35.4*/content)),format.raw/*35.11*/("""
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
                    DATE: Wed Mar 27 22:54:53 CET 2013
                    SOURCE: E:/Eigene Dateien/workspace-scala/essensplan/app/views/main.scala.html
                    HASH: 86a0e80392d99ed6ce253c8b637d52528fa667a6
                    MATRIX: 509->1|633->31|661->51|766->121|792->126|890->189|904->195|959->229|1057->291|1072->297|1126->329|1188->355|1203->361|1270->406|1652->753|1705->797|1745->799|1834->857|1934->922|1963->929
                    LINES: 19->1|23->1|24->3|29->8|29->8|30->9|30->9|30->9|31->10|31->10|31->10|32->11|32->11|32->11|46->25|46->25|46->25|48->27|56->35|56->35
                    -- GENERATED --
                */
            