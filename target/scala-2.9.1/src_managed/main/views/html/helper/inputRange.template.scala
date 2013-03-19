
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
object inputRange extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template6[play.api.data.Field,Int,Int,Array[scala.Tuple2[Symbol, Any]],FieldConstructor,play.api.i18n.Lang,play.api.templates.Html] {

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
    def apply/*13.2*/(field: play.api.data.Field, min: Int, max: Int, args: (Symbol,Any)*)(implicit handler: FieldConstructor, lang: play.api.i18n.Lang):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*13.133*/("""

"""),_display_(Seq[Any](/*15.2*/input(field, args:_*)/*15.23*/ { (id, name, value, htmlArgs) =>_display_(Seq[Any](format.raw/*15.56*/("""
    <input type="range" id=""""),_display_(Seq[Any](/*16.30*/id)),format.raw/*16.32*/("""" name=""""),_display_(Seq[Any](/*16.41*/name)),format.raw/*16.45*/("""" value=""""),_display_(Seq[Any](/*16.55*/value)),format.raw/*16.60*/("""" min=""""),_display_(Seq[Any](/*16.68*/min)),format.raw/*16.71*/("""" max=""""),_display_(Seq[Any](/*16.79*/max)),format.raw/*16.82*/("""" """),_display_(Seq[Any](/*16.85*/toHtmlArgs(htmlArgs))),format.raw/*16.105*/(""">
""")))})),format.raw/*17.2*/("""
"""))}
    }
    
    def render(field:play.api.data.Field,min:Int,max:Int,args:Array[scala.Tuple2[Symbol, Any]],handler:FieldConstructor,lang:play.api.i18n.Lang) = apply(field,min,max,args:_*)(handler,lang)
    
    def f:((play.api.data.Field,Int,Int,Array[scala.Tuple2[Symbol, Any]]) => (FieldConstructor,play.api.i18n.Lang) => play.api.templates.Html) = (field,min,max,args) => (handler,lang) => apply(field,min,max,args:_*)(handler,lang)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Dec 18 23:12:24 CET 2012
                    SOURCE: E:/Eigene Dateien/workspace-scala/essensplan/app/views/helper/inputRange.scala.html
                    HASH: 8209ebed08deb642a7985d4802a162230013d2bf
                    MATRIX: 1142->273|1352->404|1390->407|1420->428|1491->461|1557->491|1581->493|1626->502|1652->506|1698->516|1725->521|1769->529|1794->532|1838->540|1863->543|1902->546|1945->566|1979->569
                    LINES: 41->13|44->13|46->15|46->15|46->15|47->16|47->16|47->16|47->16|47->16|47->16|47->16|47->16|47->16|47->16|47->16|47->16|48->17
                    -- GENERATED --
                */
            