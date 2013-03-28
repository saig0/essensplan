
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
    def apply/*1.2*/(uri: String):play.api.templates.Html = {
        _display_ {import helper._

import tags._


Seq[Any](format.raw/*1.15*/("""

"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/main("Anmeldung")/*6.19*/ {_display_(Seq[Any](format.raw/*6.21*/("""
	
	<h1>Anmeldung für diese Seite erforderlich!</h1>
	
	<p>Authentifizierung über Google-Account</p>
	
	"""),_display_(Seq[Any](/*12.3*/form(routes.AuthenticationController.login(uri))/*12.51*/ {_display_(Seq[Any](format.raw/*12.53*/("""
		<input type="submit" value="anmelden" />
	""")))})),format.raw/*14.3*/("""
""")))})))}
    }
    
    def render(uri:String) = apply(uri)
    
    def f:((String) => play.api.templates.Html) = (uri) => apply(uri)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Mar 27 22:54:37 CET 2013
                    SOURCE: E:/Eigene Dateien/workspace-scala/essensplan/app/views/unauthenticated.scala.html
                    HASH: da50cc08d5dcf95fd681bf4619c2bba721d10733
                    MATRIX: 515->1|636->14|664->48|700->50|725->67|764->69|904->174|961->222|1001->224|1078->270
                    LINES: 19->1|25->1|27->5|28->6|28->6|28->6|34->12|34->12|34->12|36->14
                    -- GENERATED --
                */
            