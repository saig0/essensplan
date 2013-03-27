
package views.html.helper

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
/**
 * Generate an HTML input text.
 *
 * Example:
 * {{{
 * @inputText(field = myForm("name"), args = 'size -> 10, 'placeholder -> "Your name")
 * }}}
 *
 * @param field The form field.
 * @param args Set of extra attributes.
 * @param handler The field constructor.
 */
object searchInput extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template4[play.api.data.Field,Array[scala.Tuple2[Symbol, Any]],FieldConstructor,play.api.i18n.Lang,play.api.templates.Html] {

    /**
 * Generate an HTML input text.
 *
 * Example:
 * {{{
 * @inputText(field = myForm("name"), args = 'size -> 10, 'placeholder -> "Your name")
 * }}}
 *
 * @param field The form field.
 * @param args Set of extra attributes.
 * @param handler The field constructor.
 */
    def apply/*13.2*/(field: play.api.data.Field, args: (Symbol,Any)*)(implicit handler: FieldConstructor, lang: play.api.i18n.Lang):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*13.113*/("""

"""),_display_(Seq[Any](/*15.2*/input(field, args:_*)/*15.23*/ { (id, name, value, htmlArgs) =>_display_(Seq[Any](format.raw/*15.56*/("""
    <input type="search" id=""""),_display_(Seq[Any](/*16.31*/id)),format.raw/*16.33*/("""" name=""""),_display_(Seq[Any](/*16.42*/name)),format.raw/*16.46*/("""" value=""""),_display_(Seq[Any](/*16.56*/value)),format.raw/*16.61*/("""" """),_display_(Seq[Any](/*16.64*/toHtmlArgs(htmlArgs))),format.raw/*16.84*/(""">
""")))})),format.raw/*17.2*/("""
"""))}
    }
    
    def render(field:play.api.data.Field,args:Array[scala.Tuple2[Symbol, Any]],handler:FieldConstructor,lang:play.api.i18n.Lang) = apply(field,args:_*)(handler,lang)
    
    def f:((play.api.data.Field,Array[scala.Tuple2[Symbol, Any]]) => (FieldConstructor,play.api.i18n.Lang) => play.api.templates.Html) = (field,args) => (handler,lang) => apply(field,args:_*)(handler,lang)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Mar 27 10:57:19 CET 2013
                    SOURCE: E:/Eigene Dateien/workspace-scala/essensplan/app/views/helper/searchInput.scala.html
                    HASH: 76094188aaebccf5f92ed935f5f65a3510826b78
                    MATRIX: 1135->273|1325->384|1363->387|1393->408|1464->441|1531->472|1555->474|1600->483|1626->487|1672->497|1699->502|1738->505|1780->525|1814->528
                    LINES: 41->13|44->13|46->15|46->15|46->15|47->16|47->16|47->16|47->16|47->16|47->16|47->16|47->16|48->17
                    -- GENERATED --
                */
            