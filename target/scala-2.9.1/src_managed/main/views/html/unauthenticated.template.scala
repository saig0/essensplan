
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
object unauthenticated extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(message: String = "Anmeldung für diese Seite erforderlich!"):play.api.templates.Html = {
        _display_ {import helper._

import tags._


Seq[Any](format.raw/*1.63*/("""

"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/main("Anmeldung")/*6.19*/ {_display_(Seq[Any](format.raw/*6.21*/("""
	
	<h1>"""),_display_(Seq[Any](/*8.7*/{message})),format.raw/*8.16*/("""</h1>
	
""")))})))}
    }
    
    def render(message:String) = apply(message)
    
    def f:((String) => play.api.templates.Html) = (message) => apply(message)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Mar 18 22:45:29 CET 2013
                    SOURCE: E:/Eigene Dateien/workspace-scala/essensplan/app/views/unauthenticated.scala.html
                    HASH: fb68ac43c4e35d9e43fcac3917b4027ef178fdc8
                    MATRIX: 515->1|684->62|712->96|748->98|773->115|812->117|855->126|885->135
                    LINES: 19->1|25->1|27->5|28->6|28->6|28->6|30->8|30->8
                    -- GENERATED --
                */
            