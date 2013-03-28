// @SOURCE:E:/Eigene Dateien/workspace-scala/essensplan/conf/routes
// @HASH:4f1060617deeb0eaac430bf7157a86dbaeffc41f
// @DATE:Thu Mar 28 12:10:26 CET 2013

import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString

object Routes extends Router.Routes {


// @LINE:6
val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart("/"))))
                    

// @LINE:9
val controllers_RecipeController_recipes1 = Route("GET", PathPattern(List(StaticPart("/recipes"))))
                    

// @LINE:10
val controllers_RecipeController_recipesQuery2 = Route("GET", PathPattern(List(StaticPart("/recipes/query"))))
                    

// @LINE:11
val controllers_RecipeCreator_newRecipe3 = Route("GET", PathPattern(List(StaticPart("/recipes/new"))))
                    

// @LINE:12
val controllers_RecipeCreator_recipeIngredients4 = Route("GET", PathPattern(List(StaticPart("/recipes/"),DynamicPart("recipeId", """[^/]+"""),StaticPart("/ingredients"))))
                    

// @LINE:13
val controllers_RecipeCreator_addRecipeIngredient5 = Route("POST", PathPattern(List(StaticPart("/recipes/"),DynamicPart("recipeId", """[^/]+"""),StaticPart("/ingredients/new"))))
                    

// @LINE:14
val controllers_RecipeCreator_removeRecipeIngredient6 = Route("POST", PathPattern(List(StaticPart("/recipes/"),DynamicPart("recipeId", """[^/]+"""),StaticPart("/ingredients/"),DynamicPart("ingredientId", """[^/]+"""),StaticPart("/delete"))))
                    

// @LINE:15
val controllers_RecipeCreator_createRecipe7 = Route("POST", PathPattern(List(StaticPart("/recipes/create"))))
                    

// @LINE:16
val controllers_RecipeCreator_updateRecipe8 = Route("POST", PathPattern(List(StaticPart("/recipes/"),DynamicPart("recipeId", """[^/]+"""))))
                    

// @LINE:17
val controllers_RecipeCreator_removeRecipe9 = Route("POST", PathPattern(List(StaticPart("/recipes/"),DynamicPart("recipeId", """[^/]+"""),StaticPart("/delete"))))
                    

// @LINE:18
val controllers_RecipeController_recipe10 = Route("GET", PathPattern(List(StaticPart("/recipes/"),DynamicPart("recipeId", """[^/]+"""))))
                    

// @LINE:19
val controllers_RecipeController_recipe11 = Route("GET", PathPattern(List(StaticPart("/recipes/"),DynamicPart("recipeId", """[^/]+"""),StaticPart("/page/"),DynamicPart("page", """[^/]+"""))))
                    

// @LINE:20
val controllers_RecipeCreator_editRecipe12 = Route("GET", PathPattern(List(StaticPart("/recipes/"),DynamicPart("recipeId", """[^/]+"""),StaticPart("/edit"))))
                    

// @LINE:21
val controllers_RecipeCreator_recipePreparation13 = Route("GET", PathPattern(List(StaticPart("/recipes/"),DynamicPart("recipeId", """[^/]+"""),StaticPart("/preparationStep"))))
                    

// @LINE:22
val controllers_RecipeCreator_addPreparationStep14 = Route("POST", PathPattern(List(StaticPart("/recipes/"),DynamicPart("recipeId", """[^/]+"""),StaticPart("/preparationStep/new"))))
                    

// @LINE:23
val controllers_RecipeCreator_removePreparationStep15 = Route("POST", PathPattern(List(StaticPart("/recipes/"),DynamicPart("recipeId", """[^/]+"""),StaticPart("/preparationStep/"),DynamicPart("preparationStepId", """[^/]+"""),StaticPart("/delete"))))
                    

// @LINE:26
val controllers_MealController_meals16 = Route("GET", PathPattern(List(StaticPart("/meals"))))
                    

// @LINE:27
val controllers_MealController_mealsQuery17 = Route("GET", PathPattern(List(StaticPart("/meals/query"))))
                    

// @LINE:28
val controllers_MealController_mealsNewRecipe18 = Route("GET", PathPattern(List(StaticPart("/meals/create/recipe"))))
                    

// @LINE:29
val controllers_MealController_mealsNewRecipeQuery19 = Route("GET", PathPattern(List(StaticPart("/meals/create/recipe/query"))))
                    

// @LINE:30
val controllers_MealController_mealsNewDay20 = Route("GET", PathPattern(List(StaticPart("/meals/create/day/"),DynamicPart("recipeId", """[^/]+"""))))
                    

// @LINE:31
val controllers_MealController_mealsNew21 = Route("POST", PathPattern(List(StaticPart("/meals/create/"),DynamicPart("recipeId", """[^/]+"""))))
                    

// @LINE:32
val controllers_MealController_mealRemove22 = Route("POST", PathPattern(List(StaticPart("/meals/"),DynamicPart("mealId", """[^/]+"""),StaticPart("/delete"))))
                    

// @LINE:33
val controllers_MealController_mealEdit23 = Route("GET", PathPattern(List(StaticPart("/meals/"),DynamicPart("mealId", """[^/]+"""),StaticPart("/edit"))))
                    

// @LINE:34
val controllers_MealController_mealUpdate24 = Route("POST", PathPattern(List(StaticPart("/meals/"),DynamicPart("mealId", """[^/]+"""),StaticPart("/"),DynamicPart("recipeId", """[^/]+"""))))
                    

// @LINE:35
val controllers_MealController_mealShoppingList25 = Route("GET", PathPattern(List(StaticPart("/meals/shoppingList/"),DynamicPart("from", """[^/]+"""),StaticPart("/"),DynamicPart("to", """[^/]+"""))))
                    

// @LINE:36
val controllers_MealController_mealProposal26 = Route("GET", PathPattern(List(StaticPart("/meals/proposal"))))
                    

// @LINE:39
val controllers_TagController_tags27 = Route("GET", PathPattern(List(StaticPart("/tags"))))
                    

// @LINE:40
val controllers_TagController_tagNew28 = Route("POST", PathPattern(List(StaticPart("/tags/create"))))
                    

// @LINE:41
val controllers_TagController_tagRemove29 = Route("POST", PathPattern(List(StaticPart("/tags/"),DynamicPart("tagId", """[^/]+"""),StaticPart("/delete"))))
                    

// @LINE:42
val controllers_TagController_tagEdit30 = Route("GET", PathPattern(List(StaticPart("/tags/"),DynamicPart("tagId", """[^/]+"""),StaticPart("/edit"))))
                    

// @LINE:43
val controllers_TagController_tagUpdate31 = Route("POST", PathPattern(List(StaticPart("/tags/"),DynamicPart("tagId", """[^/]+"""))))
                    

// @LINE:46
val controllers_RecipeImport_importRecipe32 = Route("GET", PathPattern(List(StaticPart("/import"))))
                    

// @LINE:47
val controllers_RecipeImport_importRecipeWithId33 = Route("POST", PathPattern(List(StaticPart("/import/chefkoch/"))))
                    

// @LINE:50
val controllers_RecipeController_copyRecipe34 = Route("GET", PathPattern(List(StaticPart("/copyRecipe"))))
                    

// @LINE:51
val controllers_RecipeController_copyRecipeQuery35 = Route("GET", PathPattern(List(StaticPart("/copyRecipe/query"))))
                    

// @LINE:52
val controllers_RecipeController_copyRecipeToUser36 = Route("POST", PathPattern(List(StaticPart("/copyRecipe/"),DynamicPart("recipeId", """[^/]+"""))))
                    

// @LINE:55
val controllers_AuthenticationController_login37 = Route("GET", PathPattern(List(StaticPart("/login/"),DynamicPart("uri", """.+"""))))
                    

// @LINE:56
val controllers_AuthenticationController_openIDCallback38 = Route("GET", PathPattern(List(StaticPart("/openId/"),DynamicPart("uri", """.+"""))))
                    

// @LINE:57
val controllers_AuthenticationController_logout39 = Route("GET", PathPattern(List(StaticPart("/logout"))))
                    

// @LINE:60
val controllers_Assets_at40 = Route("GET", PathPattern(List(StaticPart("/assets/"),DynamicPart("file", """.+"""))))
                    
def documentation = List(("""GET""","""/""","""controllers.Application.index"""),("""GET""","""/recipes""","""controllers.RecipeController.recipes"""),("""GET""","""/recipes/query""","""controllers.RecipeController.recipesQuery"""),("""GET""","""/recipes/new""","""controllers.RecipeCreator.newRecipe"""),("""GET""","""/recipes/$recipeId<[^/]+>/ingredients""","""controllers.RecipeCreator.recipeIngredients(recipeId:Long)"""),("""POST""","""/recipes/$recipeId<[^/]+>/ingredients/new""","""controllers.RecipeCreator.addRecipeIngredient(recipeId:Long)"""),("""POST""","""/recipes/$recipeId<[^/]+>/ingredients/$ingredientId<[^/]+>/delete""","""controllers.RecipeCreator.removeRecipeIngredient(recipeId:Long, ingredientId:Long)"""),("""POST""","""/recipes/create""","""controllers.RecipeCreator.createRecipe"""),("""POST""","""/recipes/$recipeId<[^/]+>""","""controllers.RecipeCreator.updateRecipe(recipeId:Long)"""),("""POST""","""/recipes/$recipeId<[^/]+>/delete""","""controllers.RecipeCreator.removeRecipe(recipeId:Long)"""),("""GET""","""/recipes/$recipeId<[^/]+>""","""controllers.RecipeController.recipe(recipeId:Long, page:String = "all")"""),("""GET""","""/recipes/$recipeId<[^/]+>/page/$page<[^/]+>""","""controllers.RecipeController.recipe(recipeId:Long, page:String)"""),("""GET""","""/recipes/$recipeId<[^/]+>/edit""","""controllers.RecipeCreator.editRecipe(recipeId:Long)"""),("""GET""","""/recipes/$recipeId<[^/]+>/preparationStep""","""controllers.RecipeCreator.recipePreparation(recipeId:Long)"""),("""POST""","""/recipes/$recipeId<[^/]+>/preparationStep/new""","""controllers.RecipeCreator.addPreparationStep(recipeId:Long)"""),("""POST""","""/recipes/$recipeId<[^/]+>/preparationStep/$preparationStepId<[^/]+>/delete""","""controllers.RecipeCreator.removePreparationStep(recipeId:Long, preparationStepId:Long)"""),("""GET""","""/meals""","""controllers.MealController.meals"""),("""GET""","""/meals/query""","""controllers.MealController.mealsQuery"""),("""GET""","""/meals/create/recipe""","""controllers.MealController.mealsNewRecipe"""),("""GET""","""/meals/create/recipe/query""","""controllers.MealController.mealsNewRecipeQuery"""),("""GET""","""/meals/create/day/$recipeId<[^/]+>""","""controllers.MealController.mealsNewDay(recipeId:Long)"""),("""POST""","""/meals/create/$recipeId<[^/]+>""","""controllers.MealController.mealsNew(recipeId:Long)"""),("""POST""","""/meals/$mealId<[^/]+>/delete""","""controllers.MealController.mealRemove(mealId:Long)"""),("""GET""","""/meals/$mealId<[^/]+>/edit""","""controllers.MealController.mealEdit(mealId:Long)"""),("""POST""","""/meals/$mealId<[^/]+>/$recipeId<[^/]+>""","""controllers.MealController.mealUpdate(recipeId:Long, mealId:Long)"""),("""GET""","""/meals/shoppingList/$from<[^/]+>/$to<[^/]+>""","""controllers.MealController.mealShoppingList(from:String, to:String)"""),("""GET""","""/meals/proposal""","""controllers.MealController.mealProposal"""),("""GET""","""/tags""","""controllers.TagController.tags"""),("""POST""","""/tags/create""","""controllers.TagController.tagNew"""),("""POST""","""/tags/$tagId<[^/]+>/delete""","""controllers.TagController.tagRemove(tagId:Long)"""),("""GET""","""/tags/$tagId<[^/]+>/edit""","""controllers.TagController.tagEdit(tagId:Long)"""),("""POST""","""/tags/$tagId<[^/]+>""","""controllers.TagController.tagUpdate(tagId:Long)"""),("""GET""","""/import""","""controllers.RecipeImport.importRecipe"""),("""POST""","""/import/chefkoch/""","""controllers.RecipeImport.importRecipeWithId"""),("""GET""","""/copyRecipe""","""controllers.RecipeController.copyRecipe"""),("""GET""","""/copyRecipe/query""","""controllers.RecipeController.copyRecipeQuery"""),("""POST""","""/copyRecipe/$recipeId<[^/]+>""","""controllers.RecipeController.copyRecipeToUser(recipeId:Long)"""),("""GET""","""/login/$uri<.+>""","""controllers.AuthenticationController.login(uri:String)"""),("""GET""","""/openId/$uri<.+>""","""controllers.AuthenticationController.openIDCallback(uri:String)"""),("""GET""","""/logout""","""controllers.AuthenticationController.logout"""),("""GET""","""/assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""))
             
    
def routes:PartialFunction[RequestHeader,Handler] = {        

// @LINE:6
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.index, HandlerDef(this, "controllers.Application", "index", Nil))
   }
}
                    

// @LINE:9
case controllers_RecipeController_recipes1(params) => {
   call { 
        invokeHandler(_root_.controllers.RecipeController.recipes, HandlerDef(this, "controllers.RecipeController", "recipes", Nil))
   }
}
                    

// @LINE:10
case controllers_RecipeController_recipesQuery2(params) => {
   call { 
        invokeHandler(_root_.controllers.RecipeController.recipesQuery, HandlerDef(this, "controllers.RecipeController", "recipesQuery", Nil))
   }
}
                    

// @LINE:11
case controllers_RecipeCreator_newRecipe3(params) => {
   call { 
        invokeHandler(_root_.controllers.RecipeCreator.newRecipe, HandlerDef(this, "controllers.RecipeCreator", "newRecipe", Nil))
   }
}
                    

// @LINE:12
case controllers_RecipeCreator_recipeIngredients4(params) => {
   call(params.fromPath[Long]("recipeId", None)) { (recipeId) =>
        invokeHandler(_root_.controllers.RecipeCreator.recipeIngredients(recipeId), HandlerDef(this, "controllers.RecipeCreator", "recipeIngredients", Seq(classOf[Long])))
   }
}
                    

// @LINE:13
case controllers_RecipeCreator_addRecipeIngredient5(params) => {
   call(params.fromPath[Long]("recipeId", None)) { (recipeId) =>
        invokeHandler(_root_.controllers.RecipeCreator.addRecipeIngredient(recipeId), HandlerDef(this, "controllers.RecipeCreator", "addRecipeIngredient", Seq(classOf[Long])))
   }
}
                    

// @LINE:14
case controllers_RecipeCreator_removeRecipeIngredient6(params) => {
   call(params.fromPath[Long]("recipeId", None), params.fromPath[Long]("ingredientId", None)) { (recipeId, ingredientId) =>
        invokeHandler(_root_.controllers.RecipeCreator.removeRecipeIngredient(recipeId, ingredientId), HandlerDef(this, "controllers.RecipeCreator", "removeRecipeIngredient", Seq(classOf[Long], classOf[Long])))
   }
}
                    

// @LINE:15
case controllers_RecipeCreator_createRecipe7(params) => {
   call { 
        invokeHandler(_root_.controllers.RecipeCreator.createRecipe, HandlerDef(this, "controllers.RecipeCreator", "createRecipe", Nil))
   }
}
                    

// @LINE:16
case controllers_RecipeCreator_updateRecipe8(params) => {
   call(params.fromPath[Long]("recipeId", None)) { (recipeId) =>
        invokeHandler(_root_.controllers.RecipeCreator.updateRecipe(recipeId), HandlerDef(this, "controllers.RecipeCreator", "updateRecipe", Seq(classOf[Long])))
   }
}
                    

// @LINE:17
case controllers_RecipeCreator_removeRecipe9(params) => {
   call(params.fromPath[Long]("recipeId", None)) { (recipeId) =>
        invokeHandler(_root_.controllers.RecipeCreator.removeRecipe(recipeId), HandlerDef(this, "controllers.RecipeCreator", "removeRecipe", Seq(classOf[Long])))
   }
}
                    

// @LINE:18
case controllers_RecipeController_recipe10(params) => {
   call(params.fromPath[Long]("recipeId", None), Param[String]("page", Right("all"))) { (recipeId, page) =>
        invokeHandler(_root_.controllers.RecipeController.recipe(recipeId, page), HandlerDef(this, "controllers.RecipeController", "recipe", Seq(classOf[Long], classOf[String])))
   }
}
                    

// @LINE:19
case controllers_RecipeController_recipe11(params) => {
   call(params.fromPath[Long]("recipeId", None), params.fromPath[String]("page", None)) { (recipeId, page) =>
        invokeHandler(_root_.controllers.RecipeController.recipe(recipeId, page), HandlerDef(this, "controllers.RecipeController", "recipe", Seq(classOf[Long], classOf[String])))
   }
}
                    

// @LINE:20
case controllers_RecipeCreator_editRecipe12(params) => {
   call(params.fromPath[Long]("recipeId", None)) { (recipeId) =>
        invokeHandler(_root_.controllers.RecipeCreator.editRecipe(recipeId), HandlerDef(this, "controllers.RecipeCreator", "editRecipe", Seq(classOf[Long])))
   }
}
                    

// @LINE:21
case controllers_RecipeCreator_recipePreparation13(params) => {
   call(params.fromPath[Long]("recipeId", None)) { (recipeId) =>
        invokeHandler(_root_.controllers.RecipeCreator.recipePreparation(recipeId), HandlerDef(this, "controllers.RecipeCreator", "recipePreparation", Seq(classOf[Long])))
   }
}
                    

// @LINE:22
case controllers_RecipeCreator_addPreparationStep14(params) => {
   call(params.fromPath[Long]("recipeId", None)) { (recipeId) =>
        invokeHandler(_root_.controllers.RecipeCreator.addPreparationStep(recipeId), HandlerDef(this, "controllers.RecipeCreator", "addPreparationStep", Seq(classOf[Long])))
   }
}
                    

// @LINE:23
case controllers_RecipeCreator_removePreparationStep15(params) => {
   call(params.fromPath[Long]("recipeId", None), params.fromPath[Long]("preparationStepId", None)) { (recipeId, preparationStepId) =>
        invokeHandler(_root_.controllers.RecipeCreator.removePreparationStep(recipeId, preparationStepId), HandlerDef(this, "controllers.RecipeCreator", "removePreparationStep", Seq(classOf[Long], classOf[Long])))
   }
}
                    

// @LINE:26
case controllers_MealController_meals16(params) => {
   call { 
        invokeHandler(_root_.controllers.MealController.meals, HandlerDef(this, "controllers.MealController", "meals", Nil))
   }
}
                    

// @LINE:27
case controllers_MealController_mealsQuery17(params) => {
   call { 
        invokeHandler(_root_.controllers.MealController.mealsQuery, HandlerDef(this, "controllers.MealController", "mealsQuery", Nil))
   }
}
                    

// @LINE:28
case controllers_MealController_mealsNewRecipe18(params) => {
   call { 
        invokeHandler(_root_.controllers.MealController.mealsNewRecipe, HandlerDef(this, "controllers.MealController", "mealsNewRecipe", Nil))
   }
}
                    

// @LINE:29
case controllers_MealController_mealsNewRecipeQuery19(params) => {
   call { 
        invokeHandler(_root_.controllers.MealController.mealsNewRecipeQuery, HandlerDef(this, "controllers.MealController", "mealsNewRecipeQuery", Nil))
   }
}
                    

// @LINE:30
case controllers_MealController_mealsNewDay20(params) => {
   call(params.fromPath[Long]("recipeId", None)) { (recipeId) =>
        invokeHandler(_root_.controllers.MealController.mealsNewDay(recipeId), HandlerDef(this, "controllers.MealController", "mealsNewDay", Seq(classOf[Long])))
   }
}
                    

// @LINE:31
case controllers_MealController_mealsNew21(params) => {
   call(params.fromPath[Long]("recipeId", None)) { (recipeId) =>
        invokeHandler(_root_.controllers.MealController.mealsNew(recipeId), HandlerDef(this, "controllers.MealController", "mealsNew", Seq(classOf[Long])))
   }
}
                    

// @LINE:32
case controllers_MealController_mealRemove22(params) => {
   call(params.fromPath[Long]("mealId", None)) { (mealId) =>
        invokeHandler(_root_.controllers.MealController.mealRemove(mealId), HandlerDef(this, "controllers.MealController", "mealRemove", Seq(classOf[Long])))
   }
}
                    

// @LINE:33
case controllers_MealController_mealEdit23(params) => {
   call(params.fromPath[Long]("mealId", None)) { (mealId) =>
        invokeHandler(_root_.controllers.MealController.mealEdit(mealId), HandlerDef(this, "controllers.MealController", "mealEdit", Seq(classOf[Long])))
   }
}
                    

// @LINE:34
case controllers_MealController_mealUpdate24(params) => {
   call(params.fromPath[Long]("recipeId", None), params.fromPath[Long]("mealId", None)) { (recipeId, mealId) =>
        invokeHandler(_root_.controllers.MealController.mealUpdate(recipeId, mealId), HandlerDef(this, "controllers.MealController", "mealUpdate", Seq(classOf[Long], classOf[Long])))
   }
}
                    

// @LINE:35
case controllers_MealController_mealShoppingList25(params) => {
   call(params.fromPath[String]("from", None), params.fromPath[String]("to", None)) { (from, to) =>
        invokeHandler(_root_.controllers.MealController.mealShoppingList(from, to), HandlerDef(this, "controllers.MealController", "mealShoppingList", Seq(classOf[String], classOf[String])))
   }
}
                    

// @LINE:36
case controllers_MealController_mealProposal26(params) => {
   call { 
        invokeHandler(_root_.controllers.MealController.mealProposal, HandlerDef(this, "controllers.MealController", "mealProposal", Nil))
   }
}
                    

// @LINE:39
case controllers_TagController_tags27(params) => {
   call { 
        invokeHandler(_root_.controllers.TagController.tags, HandlerDef(this, "controllers.TagController", "tags", Nil))
   }
}
                    

// @LINE:40
case controllers_TagController_tagNew28(params) => {
   call { 
        invokeHandler(_root_.controllers.TagController.tagNew, HandlerDef(this, "controllers.TagController", "tagNew", Nil))
   }
}
                    

// @LINE:41
case controllers_TagController_tagRemove29(params) => {
   call(params.fromPath[Long]("tagId", None)) { (tagId) =>
        invokeHandler(_root_.controllers.TagController.tagRemove(tagId), HandlerDef(this, "controllers.TagController", "tagRemove", Seq(classOf[Long])))
   }
}
                    

// @LINE:42
case controllers_TagController_tagEdit30(params) => {
   call(params.fromPath[Long]("tagId", None)) { (tagId) =>
        invokeHandler(_root_.controllers.TagController.tagEdit(tagId), HandlerDef(this, "controllers.TagController", "tagEdit", Seq(classOf[Long])))
   }
}
                    

// @LINE:43
case controllers_TagController_tagUpdate31(params) => {
   call(params.fromPath[Long]("tagId", None)) { (tagId) =>
        invokeHandler(_root_.controllers.TagController.tagUpdate(tagId), HandlerDef(this, "controllers.TagController", "tagUpdate", Seq(classOf[Long])))
   }
}
                    

// @LINE:46
case controllers_RecipeImport_importRecipe32(params) => {
   call { 
        invokeHandler(_root_.controllers.RecipeImport.importRecipe, HandlerDef(this, "controllers.RecipeImport", "importRecipe", Nil))
   }
}
                    

// @LINE:47
case controllers_RecipeImport_importRecipeWithId33(params) => {
   call { 
        invokeHandler(_root_.controllers.RecipeImport.importRecipeWithId, HandlerDef(this, "controllers.RecipeImport", "importRecipeWithId", Nil))
   }
}
                    

// @LINE:50
case controllers_RecipeController_copyRecipe34(params) => {
   call { 
        invokeHandler(_root_.controllers.RecipeController.copyRecipe, HandlerDef(this, "controllers.RecipeController", "copyRecipe", Nil))
   }
}
                    

// @LINE:51
case controllers_RecipeController_copyRecipeQuery35(params) => {
   call { 
        invokeHandler(_root_.controllers.RecipeController.copyRecipeQuery, HandlerDef(this, "controllers.RecipeController", "copyRecipeQuery", Nil))
   }
}
                    

// @LINE:52
case controllers_RecipeController_copyRecipeToUser36(params) => {
   call(params.fromPath[Long]("recipeId", None)) { (recipeId) =>
        invokeHandler(_root_.controllers.RecipeController.copyRecipeToUser(recipeId), HandlerDef(this, "controllers.RecipeController", "copyRecipeToUser", Seq(classOf[Long])))
   }
}
                    

// @LINE:55
case controllers_AuthenticationController_login37(params) => {
   call(params.fromPath[String]("uri", None)) { (uri) =>
        invokeHandler(_root_.controllers.AuthenticationController.login(uri), HandlerDef(this, "controllers.AuthenticationController", "login", Seq(classOf[String])))
   }
}
                    

// @LINE:56
case controllers_AuthenticationController_openIDCallback38(params) => {
   call(params.fromPath[String]("uri", None)) { (uri) =>
        invokeHandler(_root_.controllers.AuthenticationController.openIDCallback(uri), HandlerDef(this, "controllers.AuthenticationController", "openIDCallback", Seq(classOf[String])))
   }
}
                    

// @LINE:57
case controllers_AuthenticationController_logout39(params) => {
   call { 
        invokeHandler(_root_.controllers.AuthenticationController.logout, HandlerDef(this, "controllers.AuthenticationController", "logout", Nil))
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
                