
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
					"""),_display_(Seq[Any](/*19.7*/form(routes.TagController.tagEdit(tag.id))/*19.49*/{_display_(Seq[Any](format.raw/*19.50*/("""
						<input type="submit" value="bearbeiten" />
					""")))})),format.raw/*21.7*/("""
				</td>
				<td>
					"""),_display_(Seq[Any](/*24.7*/form(routes.TagController.tagRemove(tag.id))/*24.51*/{_display_(Seq[Any](format.raw/*24.52*/("""
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
				routes.TagController.tagNew
			} else {
				routes.TagController.tagUpdate(tagId)
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
                    DATE: Wed Mar 27 23:01:43 CET 2013
                    SOURCE: E:/Eigene Dateien/workspace-scala/essensplan/app/views/tag_list.scala.html
                    HASH: e4b7dc8d73b22bd74f93d524599b6e8613fc5cb6
                    MATRIX: 526->1|673->55|700->73|740->79|777->108|816->110|885->145|897->149|923->154|965->161|1027->202|1143->283|1155->287|1168->291|1215->300|1269->318|1281->321|1308->326|1364->347|1415->389|1454->390|1541->446|1602->472|1655->516|1694->517|1780->572|1834->595|1934->660|2059->777|2098->779|2142->788|2224->848|2268->857|2415->983|2450->987|2496->1002
                    LINES: 19->1|23->1|24->3|25->4|25->4|25->4|29->8|29->8|29->8|29->8|29->8|36->15|36->15|36->15|36->15|38->17|38->17|38->17|40->19|40->19|40->19|42->21|45->24|45->24|45->24|47->26|50->29|56->35|61->40|61->40|63->42|63->42|65->44|69->48|70->49|72->51
                    -- GENERATED --
                */
            