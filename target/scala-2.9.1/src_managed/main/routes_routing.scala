// @SOURCE:E:/Eigene Dateien/workspace-scala/essensplan/conf/routes
// @HASH:2005fe15ec47e6c48dd956f004d5774a1df1a4e3
// @DATE:Sun Mar 24 11:08:59 CET 2013

import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString

object Routes extends Router.Routes {


// @LINE:6
val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart("/"))))
                    

// @LINE:9
val controllers_Application_recipes1 = Route("GET", PathPattern(List(StaticPart("/recipes"))))
                    

// @LINE:10
val controllers_Application_recipesQuery2 = Route("GET", PathPattern(List(StaticPart("/recipes/query"))))
                    

// @LINE:11
val controllers_Application_newRecipe3 = Route("GET", PathPattern(List(StaticPart("/recipes/new"))))
                    

// @LINE:12
val controllers_Application_recipeIngredients4 = Route("GET", PathPattern(List(StaticPart("/recipes/"),DynamicPart("recipeId", """[^/]+"""),StaticPart("/ingredients"))))
                    

// @LINE:13
val controllers_Application_addRecipeIngredient5 = Route("POST", PathPattern(List(StaticPart("/recipes/"),DynamicPart("recipeId", """[^/]+"""),StaticPart("/ingredients/new"))))
                    

// @LINE:14
val controllers_Application_removeRecipeIngredient6 = Route("POST", PathPattern(List(StaticPart("/recipes/"),DynamicPart("recipeId", """[^/]+"""),StaticPart("/ingredients/"),DynamicPart("ingredientId", """[^/]+"""),StaticPart("/delete"))))
                    

// @LINE:15
val controllers_Application_createRecipe7 = Route("POST", PathPattern(List(StaticPart("/recipes/create"))))
                    

// @LINE:16
val controllers_Application_updateRecipe8 = Route("POST", PathPattern(List(StaticPart("/recipes/"),DynamicPart("recipeId", """[^/]+"""))))
                    

// @LINE:17
val controllers_Application_removeRecipe9 = Route("POST", PathPattern(List(StaticPart("/recipes/"),DynamicPart("recipeId", """[^/]+"""),StaticPart("/delete"))))
                    

// @LINE:18
val controllers_Application_recipe10 = Route("GET", PathPattern(List(StaticPart("/recipes/"),DynamicPart("recipeId", """[^/]+"""))))
                    

// @LINE:19
val controllers_Application_recipe11 = Route("GET", PathPattern(List(StaticPart("/recipes/"),DynamicPart("recipeId", """[^/]+"""),StaticPart("/page/"),DynamicPart("page", """[^/]+"""))))
                    

// @LINE:20
val controllers_Application_editRecipe12 = Route("GET", PathPattern(List(StaticPart("/recipes/"),DynamicPart("recipeId", """[^/]+"""),StaticPart("/edit"))))
                    

// @LINE:21
val controllers_Application_recipePreparation13 = Route("GET", PathPattern(List(StaticPart("/recipes/"),DynamicPart("recipeId", """[^/]+"""),StaticPart("/preparationStep"))))
                    

// @LINE:22
val controllers_Application_addPreparationStep14 = Route("POST", PathPattern(List(StaticPart("/recipes/"),DynamicPart("recipeId", """[^/]+"""),StaticPart("/preparationStep/new"))))
                    

// @LINE:23
val controllers_Application_removePreparationStep15 = Route("POST", PathPattern(List(StaticPart("/recipes/"),DynamicPart("recipeId", """[^/]+"""),StaticPart("/preparationStep/"),DynamicPart("preparationStepId", """[^/]+"""),StaticPart("/delete"))))
                    

// @LINE:26
val controllers_Application_meals16 = Route("GET", PathPattern(List(StaticPart("/meals"))))
                    

// @LINE:27
val controllers_Application_mealsQuery17 = Route("GET", PathPattern(List(StaticPart("/meals/query"))))
                    

// @LINE:28
val controllers_Application_mealsNewRecipe18 = Route("GET", PathPattern(List(StaticPart("/meals/create/recipe"))))
                    

// @LINE:29
val controllers_Application_mealsNewRecipeQuery19 = Route("GET", PathPattern(List(StaticPart("/meals/create/recipe/query"))))
                    

// @LINE:30
val controllers_Application_mealsNewDay20 = Route("GET", PathPattern(List(StaticPart("/meals/create/day/"),DynamicPart("recipeId", """[^/]+"""))))
                    

// @LINE:31
val controllers_Application_mealsNew21 = Route("POST", PathPattern(List(StaticPart("/meals/create/"),DynamicPart("recipeId", """[^/]+"""))))
                    

// @LINE:32
val controllers_Application_mealRemove22 = Route("POST", PathPattern(List(StaticPart("/meals/"),DynamicPart("mealId", """[^/]+"""),StaticPart("/delete"))))
                    

// @LINE:33
val controllers_Application_mealEdit23 = Route("GET", PathPattern(List(StaticPart("/meals/"),DynamicPart("mealId", """[^/]+"""),StaticPart("/edit"))))
                    

// @LINE:34
val controllers_Application_mealUpdate24 = Route("POST", PathPattern(List(StaticPart("/meals/"),DynamicPart("mealId", """[^/]+"""),StaticPart("/"),DynamicPart("recipeId", """[^/]+"""))))
                    

// @LINE:35
val controllers_Application_mealShoppingList25 = Route("GET", PathPattern(List(StaticPart("/meals/shoppingList/"),DynamicPart("from", """[^/]+"""),StaticPart("/"),DynamicPart("to", """[^/]+"""))))
                    

// @LINE:36
val controllers_Application_mealProposal26 = Route("GET", PathPattern(List(StaticPart("/meals/proposal"))))
                    

// @LINE:39
val controllers_Application_tags27 = Route("GET", PathPattern(List(StaticPart("/tags"))))
                    

// @LINE:40
val controllers_Application_tagNew28 = Route("POST", PathPattern(List(StaticPart("/tags/create"))))
                    

// @LINE:41
val controllers_Application_tagRemove29 = Route("POST", PathPattern(List(StaticPart("/tags/"),DynamicPart("tagId", """[^/]+"""),StaticPart("/delete"))))
                    

// @LINE:42
val controllers_Application_tagEdit30 = Route("GET", PathPattern(List(StaticPart("/tags/"),DynamicPart("tagId", """[^/]+"""),StaticPart("/edit"))))
                    

// @LINE:43
val controllers_Application_tagUpdate31 = Route("POST", PathPattern(List(StaticPart("/tags/"),DynamicPart("tagId", """[^/]+"""))))
                    

// @LINE:46
val controllers_Application_importRecipe32 = Route("GET", PathPattern(List(StaticPart("/import"))))
                    

// @LINE:47
val controllers_Application_importRecipeWithId33 = Route("POST", PathPattern(List(StaticPart("/import/chefkoch/"))))
                    

// @LINE:50
val controllers_Application_copyRecipe34 = Route("GET", PathPattern(List(StaticPart("/copyRecipe"))))
                    

// @LINE:51
val controllers_Application_copyRecipeQuery35 = Route("GET", PathPattern(List(StaticPart("/copyRecipe/query"))))
                    

// @LINE:52
val controllers_Application_copyRecipeToUser36 = Route("POST", PathPattern(List(StaticPart("/copyRecipe/"),DynamicPart("recipeId", """[^/]+"""))))
                    

// @LINE:55
val controllers_Application_login37 = Route("GET", PathPattern(List(StaticPart("/login"))))
                    

// @LINE:56
val controllers_Application_openIDCallback38 = Route("GET", PathPattern(List(StaticPart("/login/openId"))))
                    

// @LINE:57
val controllers_Application_logout39 = Route("GET", PathPattern(List(StaticPart("/logout"))))
                    

// @LINE:60
val controllers_Assets_at40 = Route("GET", PathPattern(List(StaticPart("/assets/"),DynamicPart("file", """.+"""))))
                    
def documentation = List(("""GET""","""/""","""controllers.Application.index"""),("""GET""","""/recipes""","""controllers.Application.recipes"""),("""GET""","""/recipes/query""","""controllers.Application.recipesQuery"""),("""GET""","""/recipes/new""","""controllers.Application.newRecipe"""),("""GET""","""/recipes/$recipeId<[^/]+>/ingredients""","""controllers.Application.recipeIngredients(recipeId:Long)"""),("""POST""","""/recipes/$recipeId<[^/]+>/ingredients/new""","""controllers.Application.addRecipeIngredient(recipeId:Long)"""),("""POST""","""/recipes/$recipeId<[^/]+>/ingredients/$ingredientId<[^/]+>/delete""","""controllers.Application.removeRecipeIngredient(recipeId:Long, ingredientId:Long)"""),("""POST""","""/recipes/create""","""controllers.Application.createRecipe"""),("""POST""","""/recipes/$recipeId<[^/]+>""","""controllers.Application.updateRecipe(recipeId:Long)"""),("""POST""","""/recipes/$recipeId<[^/]+>/delete""","""controllers.Application.removeRecipe(recipeId:Long)"""),("""GET""","""/recipes/$recipeId<[^/]+>""","""controllers.Application.recipe(recipeId:Long, page:String = "all")"""),("""GET""","""/recipes/$recipeId<[^/]+>/page/$page<[^/]+>""","""controllers.Application.recipe(recipeId:Long, page:String)"""),("""GET""","""/recipes/$recipeId<[^/]+>/edit""","""controllers.Application.editRecipe(recipeId:Long)"""),("""GET""","""/recipes/$recipeId<[^/]+>/preparationStep""","""controllers.Application.recipePreparation(recipeId:Long)"""),("""POST""","""/recipes/$recipeId<[^/]+>/preparationStep/new""","""controllers.Application.addPreparationStep(recipeId:Long)"""),("""POST""","""/recipes/$recipeId<[^/]+>/preparationStep/$preparationStepId<[^/]+>/delete""","""controllers.Application.removePreparationStep(recipeId:Long, preparationStepId:Long)"""),("""GET""","""/meals""","""controllers.Application.meals"""),("""GET""","""/meals/query""","""controllers.Application.mealsQuery"""),("""GET""","""/meals/create/recipe""","""controllers.Application.mealsNewRecipe"""),("""GET""","""/meals/create/recipe/query""","""controllers.Application.mealsNewRecipeQuery"""),("""GET""","""/meals/create/day/$recipeId<[^/]+>""","""controllers.Application.mealsNewDay(recipeId:Long)"""),("""POST""","""/meals/create/$recipeId<[^/]+>""","""controllers.Application.mealsNew(recipeId:Long)"""),("""POST""","""/meals/$mealId<[^/]+>/delete""","""controllers.Application.mealRemove(mealId:Long)"""),("""GET""","""/meals/$mealId<[^/]+>/edit""","""controllers.Application.mealEdit(mealId:Long)"""),("""POST""","""/meals/$mealId<[^/]+>/$recipeId<[^/]+>""","""controllers.Application.mealUpdate(recipeId:Long, mealId:Long)"""),("""GET""","""/meals/shoppingList/$from<[^/]+>/$to<[^/]+>""","""controllers.Application.mealShoppingList(from:String, to:String)"""),("""GET""","""/meals/proposal""","""controllers.Application.mealProposal"""),("""GET""","""/tags""","""controllers.Application.tags"""),("""POST""","""/tags/create""","""controllers.Application.tagNew"""),("""POST""","""/tags/$tagId<[^/]+>/delete""","""controllers.Application.tagRemove(tagId:Long)"""),("""GET""","""/tags/$tagId<[^/]+>/edit""","""controllers.Application.tagEdit(tagId:Long)"""),("""POST""","""/tags/$tagId<[^/]+>""","""controllers.Application.tagUpdate(tagId:Long)"""),("""GET""","""/import""","""controllers.Application.importRecipe"""),("""POST""","""/import/chefkoch/""","""controllers.Application.importRecipeWithId"""),("""GET""","""/copyRecipe""","""controllers.Application.copyRecipe"""),("""GET""","""/copyRecipe/query""","""controllers.Application.copyRecipeQuery"""),("""POST""","""/copyRecipe/$recipeId<[^/]+>""","""controllers.Application.copyRecipeToUser(recipeId:Long)"""),("""GET""","""/login""","""controllers.Application.login"""),("""GET""","""/login/openId""","""controllers.Application.openIDCallback"""),("""GET""","""/logout""","""controllers.Application.logout"""),("""GET""","""/assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""))
             
    
def routes:PartialFunction[RequestHeader,Handler] = {        

// @LINE:6
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.index, HandlerDef(this, "controllers.Application", "index", Nil))
   }
}
                    

// @LINE:9
case controllers_Application_recipes1(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.recipes, HandlerDef(this, "controllers.Application", "recipes", Nil))
   }
}
                    

// @LINE:10
case controllers_Application_recipesQuery2(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.recipesQuery, HandlerDef(this, "controllers.Application", "recipesQuery", Nil))
   }
}
                    

// @LINE:11
case controllers_Application_newRecipe3(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.newRecipe, HandlerDef(this, "controllers.Application", "newRecipe", Nil))
   }
}
                    

// @LINE:12
case controllers_Application_recipeIngredients4(params) => {
   call(params.fromPath[Long]("recipeId", None)) { (recipeId) =>
        invokeHandler(_root_.controllers.Application.recipeIngredients(recipeId), HandlerDef(this, "controllers.Application", "recipeIngredients", Seq(classOf[Long])))
   }
}
                    

// @LINE:13
case controllers_Application_addRecipeIngredient5(params) => {
   call(params.fromPath[Long]("recipeId", None)) { (recipeId) =>
        invokeHandler(_root_.controllers.Application.addRecipeIngredient(recipeId), HandlerDef(this, "controllers.Application", "addRecipeIngredient", Seq(classOf[Long])))
   }
}
                    

// @LINE:14
case controllers_Application_removeRecipeIngredient6(params) => {
   call(params.fromPath[Long]("recipeId", None), params.fromPath[Long]("ingredientId", None)) { (recipeId, ingredientId) =>
        invokeHandler(_root_.controllers.Application.removeRecipeIngredient(recipeId, ingredientId), HandlerDef(this, "controllers.Application", "removeRecipeIngredient", Seq(classOf[Long], classOf[Long])))
   }
}
                    

// @LINE:15
case controllers_Application_createRecipe7(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.createRecipe, HandlerDef(this, "controllers.Application", "createRecipe", Nil))
   }
}
                    

// @LINE:16
case controllers_Application_updateRecipe8(params) => {
   call(params.fromPath[Long]("recipeId", None)) { (recipeId) =>
        invokeHandler(_root_.controllers.Application.updateRecipe(recipeId), HandlerDef(this, "controllers.Application", "updateRecipe", Seq(classOf[Long])))
   }
}
                    

// @LINE:17
case controllers_Application_removeRecipe9(params) => {
   call(params.fromPath[Long]("recipeId", None)) { (recipeId) =>
        invokeHandler(_root_.controllers.Application.removeRecipe(recipeId), HandlerDef(this, "controllers.Application", "removeRecipe", Seq(classOf[Long])))
   }
}
                    

// @LINE:18
case controllers_Application_recipe10(params) => {
   call(params.fromPath[Long]("recipeId", None), Param[String]("page", Right("all"))) { (recipeId, page) =>
        invokeHandler(_root_.controllers.Application.recipe(recipeId, page), HandlerDef(this, "controllers.Application", "recipe", Seq(classOf[Long], classOf[String])))
   }
}
                    

// @LINE:19
case controllers_Application_recipe11(params) => {
   call(params.fromPath[Long]("recipeId", None), params.fromPath[String]("page", None)) { (recipeId, page) =>
        invokeHandler(_root_.controllers.Application.recipe(recipeId, page), HandlerDef(this, "controllers.Application", "recipe", Seq(classOf[Long], classOf[String])))
   }
}
                    

// @LINE:20
case controllers_Application_editRecipe12(params) => {
   call(params.fromPath[Long]("recipeId", None)) { (recipeId) =>
        invokeHandler(_root_.controllers.Application.editRecipe(recipeId), HandlerDef(this, "controllers.Application", "editRecipe", Seq(classOf[Long])))
   }
}
                    

// @LINE:21
case controllers_Application_recipePreparation13(params) => {
   call(params.fromPath[Long]("recipeId", None)) { (recipeId) =>
        invokeHandler(_root_.controllers.Application.recipePreparation(recipeId), HandlerDef(this, "controllers.Application", "recipePreparation", Seq(classOf[Long])))
   }
}
                    

// @LINE:22
case controllers_Application_addPreparationStep14(params) => {
   call(params.fromPath[Long]("recipeId", None)) { (recipeId) =>
        invokeHandler(_root_.controllers.Application.addPreparationStep(recipeId), HandlerDef(this, "controllers.Application", "addPreparationStep", Seq(classOf[Long])))
   }
}
                    

// @LINE:23
case controllers_Application_removePreparationStep15(params) => {
   call(params.fromPath[Long]("recipeId", None), params.fromPath[Long]("preparationStepId", None)) { (recipeId, preparationStepId) =>
        invokeHandler(_root_.controllers.Application.removePreparationStep(recipeId, preparationStepId), HandlerDef(this, "controllers.Application", "removePreparationStep", Seq(classOf[Long], classOf[Long])))
   }
}
                    

// @LINE:26
case controllers_Application_meals16(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.meals, HandlerDef(this, "controllers.Application", "meals", Nil))
   }
}
                    

// @LINE:27
case controllers_Application_mealsQuery17(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.mealsQuery, HandlerDef(this, "controllers.Application", "mealsQuery", Nil))
   }
}
                    

// @LINE:28
case controllers_Application_mealsNewRecipe18(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.mealsNewRecipe, HandlerDef(this, "controllers.Application", "mealsNewRecipe", Nil))
   }
}
                    

// @LINE:29
case controllers_Application_mealsNewRecipeQuery19(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.mealsNewRecipeQuery, HandlerDef(this, "controllers.Application", "mealsNewRecipeQuery", Nil))
   }
}
                    

// @LINE:30
case controllers_Application_mealsNewDay20(params) => {
   call(params.fromPath[Long]("recipeId", None)) { (recipeId) =>
        invokeHandler(_root_.controllers.Application.mealsNewDay(recipeId), HandlerDef(this, "controllers.Application", "mealsNewDay", Seq(classOf[Long])))
   }
}
                    

// @LINE:31
case controllers_Application_mealsNew21(params) => {
   call(params.fromPath[Long]("recipeId", None)) { (recipeId) =>
        invokeHandler(_root_.controllers.Application.mealsNew(recipeId), HandlerDef(this, "controllers.Application", "mealsNew", Seq(classOf[Long])))
   }
}
                    

// @LINE:32
case controllers_Application_mealRemove22(params) => {
   call(params.fromPath[Long]("mealId", None)) { (mealId) =>
        invokeHandler(_root_.controllers.Application.mealRemove(mealId), HandlerDef(this, "controllers.Application", "mealRemove", Seq(classOf[Long])))
   }
}
                    

// @LINE:33
case controllers_Application_mealEdit23(params) => {
   call(params.fromPath[Long]("mealId", None)) { (mealId) =>
        invokeHandler(_root_.controllers.Application.mealEdit(mealId), HandlerDef(this, "controllers.Application", "mealEdit", Seq(classOf[Long])))
   }
}
                    

// @LINE:34
case controllers_Application_mealUpdate24(params) => {
   call(params.fromPath[Long]("recipeId", None), params.fromPath[Long]("mealId", None)) { (recipeId, mealId) =>
        invokeHandler(_root_.controllers.Application.mealUpdate(recipeId, mealId), HandlerDef(this, "controllers.Application", "mealUpdate", Seq(classOf[Long], classOf[Long])))
   }
}
                    

// @LINE:35
case controllers_Application_mealShoppingList25(params) => {
   call(params.fromPath[String]("from", None), params.fromPath[String]("to", None)) { (from, to) =>
        invokeHandler(_root_.controllers.Application.mealShoppingList(from, to), HandlerDef(this, "controllers.Application", "mealShoppingList", Seq(classOf[String], classOf[String])))
   }
}
                    

// @LINE:36
case controllers_Application_mealProposal26(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.mealProposal, HandlerDef(this, "controllers.Application", "mealProposal", Nil))
   }
}
                    

// @LINE:39
case controllers_Application_tags27(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.tags, HandlerDef(this, "controllers.Application", "tags", Nil))
   }
}
                    

// @LINE:40
case controllers_Application_tagNew28(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.tagNew, HandlerDef(this, "controllers.Application", "tagNew", Nil))
   }
}
                    

// @LINE:41
case controllers_Application_tagRemove29(params) => {
   call(params.fromPath[Long]("tagId", None)) { (tagId) =>
        invokeHandler(_root_.controllers.Application.tagRemove(tagId), HandlerDef(this, "controllers.Application", "tagRemove", Seq(classOf[Long])))
   }
}
                    

// @LINE:42
case controllers_Application_tagEdit30(params) => {
   call(params.fromPath[Long]("tagId", None)) { (tagId) =>
        invokeHandler(_root_.controllers.Application.tagEdit(tagId), HandlerDef(this, "controllers.Application", "tagEdit", Seq(classOf[Long])))
   }
}
                    

// @LINE:43
case controllers_Application_tagUpdate31(params) => {
   call(params.fromPath[Long]("tagId", None)) { (tagId) =>
        invokeHandler(_root_.controllers.Application.tagUpdate(tagId), HandlerDef(this, "controllers.Application", "tagUpdate", Seq(classOf[Long])))
   }
}
                    

// @LINE:46
case controllers_Application_importRecipe32(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.importRecipe, HandlerDef(this, "controllers.Application", "importRecipe", Nil))
   }
}
                    

// @LINE:47
case controllers_Application_importRecipeWithId33(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.importRecipeWithId, HandlerDef(this, "controllers.Application", "importRecipeWithId", Nil))
   }
}
                    

// @LINE:50
case controllers_Application_copyRecipe34(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.copyRecipe, HandlerDef(this, "controllers.Application", "copyRecipe", Nil))
   }
}
                    

// @LINE:51
case controllers_Application_copyRecipeQuery35(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.copyRecipeQuery, HandlerDef(this, "controllers.Application", "copyRecipeQuery", Nil))
   }
}
                    

// @LINE:52
case controllers_Application_copyRecipeToUser36(params) => {
   call(params.fromPath[Long]("recipeId", None)) { (recipeId) =>
        invokeHandler(_root_.controllers.Application.copyRecipeToUser(recipeId), HandlerDef(this, "controllers.Application", "copyRecipeToUser", Seq(classOf[Long])))
   }
}
                    

// @LINE:55
case controllers_Application_login37(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.login, HandlerDef(this, "controllers.Application", "login", Nil))
   }
}
                    

// @LINE:56
case controllers_Application_openIDCallback38(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.openIDCallback, HandlerDef(this, "controllers.Application", "openIDCallback", Nil))
   }
}
                    

// @LINE:57
case controllers_Application_logout39(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.logout, HandlerDef(this, "controllers.Application", "logout", Nil))
   }
}
                    

// @LINE:60
case controllers_Assets_at40(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(_root_.controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String])))
   }
}
                    
}
    
}
                