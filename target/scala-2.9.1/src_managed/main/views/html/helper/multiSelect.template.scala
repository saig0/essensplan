
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
 * Generate an HTML multi-select.
 *
 * Example:
 * {{{
 * @select(field = myForm("categories"), options = options("A","B","C"))
 * }}}
 *
 * @param field The form field.
 * @param args Set of extra attributes.
 * @param handler The field constructor.
 */
object multiSelect extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template5[play.api.data.Field,Seq[scala.Tuple2[String, String]],Array[scala.Tuple2[Symbol, Any]],FieldConstructor,play.api.i18n.Lang,play.api.templates.Html] {

    /**
 * Generate an HTML multi-select.
 *
 * Example:
 * {{{
 * @select(field = myForm("categories"), options = options("A","B","C"))
 * }}}
 *
 * @param field The form field.
 * @param args Set of extra attributes.
 * @param handler The field constructor.
 */
    def apply/*13.2*/(field: play.api.data.Field, options: Seq[(String,String)], args: (Symbol,Any)*)(implicit handler: FieldConstructor, lang: play.api.i18n.Lang):play.api.templates.Html = {
        _display_ {
def /*15.2*/values/*15.8*/ = {{ field.indexes.map { v => field("[" + v + "]").value } }};
Seq[Any](format.raw/*13.144*/("""

"""),format.raw/*15.69*/("""

"""),_display_(Seq[Any](/*17.2*/input(field, args:_*)/*17.23*/ { (id, name, value, htmlArgs) =>_display_(Seq[Any](format.raw/*17.56*/("""
	<select id=""""),_display_(Seq[Any](/*18.15*/id)),format.raw/*18.17*/("""" name=""""),_display_(Seq[Any](/*18.26*/name)),format.raw/*18.30*/("""" """),_display_(Seq[Any](/*18.33*/toHtmlArgs(htmlArgs))),format.raw/*18.53*/(""" multiple="multiple">
		"""),_display_(Seq[Any](/*19.4*/options/*19.11*/.map/*19.15*/ { v =>_display_(Seq[Any](format.raw/*19.22*/("""
			<option value=""""),_display_(Seq[Any](/*20.20*/v/*20.21*/._1)),format.raw/*20.24*/("""" """),_display_(Seq[Any](/*20.27*/{if(values.contains(Some(v._1))) "selected" else ""})),format.raw/*20.79*/(""">"""),_display_(Seq[Any](/*20.81*/v/*20.82*/._2)),format.raw/*20.85*/("""</option>
		""")))})),format.raw/*21.4*/("""
	</select>
""")))})),format.raw/*23.2*/("""
"""))}
    }
    
    def render(field:play.api.data.Field,options:Seq[scala.Tuple2[String, String]],args:Array[scala.Tuple2[Symbol, Any]],handler:FieldConstructor,lang:play.api.i18n.Lang) = apply(field,options,args:_*)(handler,lang)
    
    def f:((play.api.data.Field,Seq[scala.Tuple2[String, String]],Array[scala.Tuple2[Symbol, Any]]) => (FieldConstructor,play.api.i18n.Lang) => play.api.templates.Html) = (field,options,args) => (handler,lang) => apply(field,options,args:_*)(handler,lang)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Jan 14 23:47:57 CET 2013
                    SOURCE: E:/Eigene Dateien/workspace-scala/essensplan/app/views/helper/multiSelect.scala.html
                    HASH: 125a174222dbaa9a5379d07c3a751508585f5951
                    MATRIX: 1167->273|1370->420|1384->426|1477->415|1509->487|1549->492|1579->513|1650->546|1702->562|1726->564|1771->573|1797->577|1836->580|1878->600|1939->626|1955->633|1968->637|2013->644|2070->665|2080->666|2105->669|2144->672|2218->724|2256->726|2266->727|2291->730|2336->744|2382->759
                    LINES: 41->13|43->15|43->15|44->13|46->15|48->17|48->17|48->17|49->18|49->18|49->18|49->18|49->18|49->18|50->19|50->19|50->19|50->19|51->20|51->20|51->20|51->20|51->20|51->20|51->20|51->20|52->21|54->23
                    -- GENERATED --
                */
            