
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
object tag_list extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[List[Tag],Form[Tag],Long,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(tags: List[Tag], tagForm: Form[Tag], tagId: Long = 0):play.api.templates.Html = {
        _display_ {import helper._


Seq[Any](format.raw/*1.56*/("""
"""),format.raw/*3.1*/("""    
"""),_display_(Seq[Any](/*4.2*/main("Stichwörter verwalten")/*4.31*/ {_display_(Seq[Any](format.raw/*4.33*/("""

	<h1>Stichwörter</h1>	
	
	<span>"""),_display_(Seq[Any](/*8.9*/tags/*8.13*/.size)),format.raw/*8.18*/(""" Stich"""),_display_(Seq[Any](/*8.25*/{if(tags.size > 1) "wörter" else "worte"})),format.raw/*8.66*/(""" gefunden</span>
	
	<table border="1">
		<tr>
			<th>Stichwort</th>
		</tr>
	
		"""),_display_(Seq[Any](/*15.4*/tags/*15.8*/.map/*15.12*/ { tag =>_display_(Seq[Any](format.raw/*15.21*/("""
			<tr>
				<td>"""),_display_(Seq[Any](/*17.10*/tag/*17.13*/.name)),format.raw/*17.18*/("""</td>
				<td>
					"""),_display_(Seq[Any](/*19.7*/form(routes.Application.tagEdit(tag.id))/*19.47*/{_display_(Seq[Any](format.raw/*19.48*/("""
						<input type="submit" value="bearbeiten" />
					""")))})),format.raw/*21.7*/("""
				</td>
				<td>
					"""),_display_(Seq[Any](/*24.7*/form(routes.Application.tagRemove(tag.id))/*24.49*/{_display_(Seq[Any](format.raw/*24.50*/("""
						<input type="submit" value="entfernen" />
					""")))})),format.raw/*26.7*/("""
				</td>
			</tr>
		""")))})),format.raw/*29.4*/("""	
	</table>
	<br/>
	
	<fieldset>
		<legend>Neuer Tag</legend>
		"""),_display_(Seq[Any](/*35.4*/form(
			if(tagId == 0) {
				routes.Application.tagNew
			} else {
				routes.Application.tagUpdate(tagId)
			})/*40.6*/ {_display_(Seq[Any](format.raw/*40.8*/("""
			
			"""),_display_(Seq[Any](/*42.5*/inputText(tagForm("name"), '_label -> "Name des Stichworts"))),format.raw/*42.65*/("""
			
			"""),_display_(Seq[Any](/*44.5*/{ if(tagId == 0) {
				<input type="submit" value="hinzufügen" />
			} else {
				<input type="submit" value="ändern" />
			}})),format.raw/*48.6*/("""
		""")))})),format.raw/*49.4*/("""
	</fieldset>
""")))})),format.raw/*51.2*/("""
	
	"""))}
    }
    
    def render(tags:List[Tag],tagForm:Form[Tag],tagId:Long) = apply(tags,tagForm,tagId)
    
    def f:((List[Tag],Form[Tag],Long) => play.api.templates.Html) = (tags,tagForm,tagId) => apply(tags,tagForm,tagId)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Mar 27 10:57:19 CET 2013
                    SOURCE: E:/Eigene Dateien/workspace-scala/essensplan/app/views/tag_list.scala.html
                    HASH: bbc6dde1ada0de15f67d0552080679b8979b0c4b
                    MATRIX: 526->1|673->55|700->73|740->79|777->108|816->110|885->145|897->149|923->154|965->161|1027->202|1143->283|1155->287|1168->291|1215->300|1269->318|1281->321|1308->326|1364->347|1413->387|1452->388|1539->444|1600->470|1651->512|1690->513|1776->568|1830->591|1930->656|2051->769|2090->771|2134->780|2216->840|2260->849|2407->975|2442->979|2488->994
                    LINES: 19->1|23->1|24->3|25->4|25->4|25->4|29->8|29->8|29->8|29->8|29->8|36->15|36->15|36->15|36->15|38->17|38->17|38->17|40->19|40->19|40->19|42->21|45->24|45->24|45->24|47->26|50->29|56->35|61->40|61->40|63->42|63->42|65->44|69->48|70->49|72->51
                    -- GENERATED --
                */
            