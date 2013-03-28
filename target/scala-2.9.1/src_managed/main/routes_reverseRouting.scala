// @SOURCE:E:/Eigene Dateien/workspace-scala/essensplan/conf/routes
// @HASH:4f1060617deeb0eaac430bf7157a86dbaeffc41f
// @DATE:Thu Mar 28 12:10:26 CET 2013

import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString


// @LINE:60
// @LINE:57
// @LINE:56
// @LINE:55
// @LINE:52
// @LINE:51
// @LINE:50
// @LINE:47
// @LINE:46
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:6
package controllers {

// @LINE:60
class ReverseAssets {
    


 
// @LINE:60
def at(file:String) = {
   Call("GET", "/assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                        

                      
    
}
                            

// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
class ReverseTagController {
    


 
// @LINE:39
def tags() = {
   Call("GET", "/tags")
}
                                                        
 
// @LINE:40
def tagNew() = {
   Call("POST", "/tags/create")
}
                                                        
 
// @LINE:43
def tagUpdate(tagId:Long) = {
   Call("POST", "/tags/" + implicitly[PathBindable[Long]].unbind("tagId", tagId))
}
                                                        
 
// @LINE:41
def tagRemove(tagId:Long) = {
   Call("POST", "/tags/" + implicitly[PathBindable[Long]].unbind("tagId", tagId) + "/delete")
}
                                                        
 
// @LINE:42
def tagEdit(tagId:Long) = {
   Call("GET", "/tags/" + implicitly[PathBindable[Long]].unbind("tagId", tagId) + "/edit")
}
                                                        

                      
    
}
                            

// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
class ReverseMealController {
    


 
// @LINE:31
def mealsNew(recipeId:Long) = {
   Call("POST", "/meals/create/" + implicitly[PathBindable[Long]].unbind("recipeId", recipeId))
}
                                                        
 
// @LINE:26
def meals() = {
   Call("GET", "/meals")
}
                                                        
 
// @LINE:33
def mealEdit(mealId:Long) = {
   Call("GET", "/meals/" + implicitly[PathBindable[Long]].unbind("mealId", mealId) + "/edit")
}
                                                        
 
// @LINE:32
def mealRemove(mealId:Long) = {
   Call("POST", "/meals/" + implicitly[PathBindable[Long]].unbind("mealId", mealId) + "/delete")
}
                                                        
 
// @LINE:28
def mealsNewRecipe() = {
   Call("GET", "/meals/create/recipe")
}
                                                        
 
// @LINE:35
def mealShoppingList(from:String, to:String) = {
   Call("GET", "/meals/shoppingList/" + implicitly[PathBindable[String]].unbind("from", from) + "/" + implicitly[PathBindable[String]].unbind("to", to))
}
                                                        
 
// @LINE:34
def mealUpdate(recipeId:Long, mealId:Long) = {
   Call("POST", "/meals/" + implicitly[PathBindable[Long]].unbind("mealId", mealId) + "/" + implicitly[PathBindable[Long]].unbind("recipeId", recipeId))
}
                                                        
 
// @LINE:27
def mealsQuery() = {
   Call("GET", "/meals/query")
}
                                                        
 
// @LINE:29
def mealsNewRecipeQuery() = {
   Call("GET", "/meals/create/recipe/query")
}
                                                        
 
// @LINE:36
def mealProposal() = {
   Call("GET", "/meals/proposal")
}
                                                        
 
// @LINE:30
def mealsNewDay(recipeId:Long) = {
   Call("GET", "/meals/create/day/" + implicitly[PathBindable[Long]].unbind("recipeId", recipeId))
}
                                                        

                      
    
}
                            

// @LINE:52
// @LINE:51
// @LINE:50
// @LINE:19
// @LINE:18
// @LINE:10
// @LINE:9
class ReverseRecipeController {
    


 
// @LINE:19
// @LINE:18
def recipe(recipeId:Long, page:String) = {
   (recipeId, page) match {
// @LINE:18
case (recipeId, page) if page == "all" => Call("GET", "/recipes/" + implicitly[PathBindable[Long]].unbind("recipeId", recipeId))
                                                                
// @LINE:19
case (recipeId, page) if true => Call("GET", "/recipes/" + implicitly[PathBindable[Long]].unbind("recipeId", recipeId) + "/page/" + implicitly[PathBindable[String]].unbind("page", page))
                                                                    
   }
}
                                                        
 
// @LINE:9
def recipes() = {
   Call("GET", "/recipes")
}
                                                        
 
// @LINE:10
def recipesQuery() = {
   Call("GET", "/recipes/query")
}
                                                        
 
// @LINE:51
def copyRecipeQuery() = {
   Call("GET", "/copyRecipe/query")
}
                                                        
 
// @LINE:52
def copyRecipeToUser(recipeId:Long) = {
   Call("POST", "/copyRecipe/" + implicitly[PathBindable[Long]].unbind("recipeId", recipeId))
}
                                                        
 
// @LINE:50
def copyRecipe() = {
   Call("GET", "/copyRecipe")
}
                                                        

                      
    
}
                            

// @LINE:57
// @LINE:56
// @LINE:55
class ReverseAuthenticationController {
    


 
// @LINE:56
def openIDCallback(uri:String) = {
   Call("GET", "/openId/" + implicitly[PathBindable[String]].unbind("uri", uri))
}
                                                        
 
// @LINE:57
def logout() = {
   Call("GET", "/logout")
}
                                                        
 
// @LINE:55
def login(uri:String) = {
   Call("GET", "/login/" + implicitly[PathBindable[String]].unbind("uri", uri))
}
                                                        

                      
    
}
                            

// @LINE:47
// @LINE:46
class ReverseRecipeImport {
    


 
// @LINE:46
def importRecipe() = {
   Call("GET", "/import")
}
                                                        
 
// @LINE:47
def importRecipeWithId() = {
   Call("POST", "/import/chefkoch/")
}
                                                        

                      
    
}
                            

// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
class ReverseRecipeCreator {
    


 
// @LINE:15
def createRecipe() = {
   Call("POST", "/recipes/create")
}
                                                        
 
// @LINE:17
def removeRecipe(recipeId:Long) = {
   Call("POST", "/recipes/" + implicitly[PathBindable[Long]].unbind("recipeId", recipeId) + "/delete")
}
                                                        
 
// @LINE:23
def removePreparationStep(recipeId:Long, preparationStepId:Long) = {
   Call("POST", "/recipes/" + implicitly[PathBindable[Long]].unbind("recipeId", recipeId) + "/preparationStep/" + implicitly[PathBindable[Long]].unbind("preparationStepId", preparationStepId) + "/delete")
}
                                                        
 
// @LINE:14
def removeRecipeIngredient(recipeId:Long, ingredientId:Long) = {
   Call("POST", "/recipes/" + implicitly[PathBindable[Long]].unbind("recipeId", recipeId) + "/ingredients/" + implicitly[PathBindable[Long]].unbind("ingredientId", ingredientId) + "/delete")
}
                                                        
 
// @LINE:20
def editRecipe(recipeId:Long) = {
   Call("GET", "/recipes/" + implicitly[PathBindable[Long]].unbind("recipeId", recipeId) + "/edit")
}
                                                        
 
// @LINE:12
def recipeIngredients(recipeId:Long) = {
   Call("GET", "/recipes/" + implicitly[PathBindable[Long]].unbind("recipeId", recipeId) + "/ingredients")
}
                                                        
 
// @LINE:21
def recipePreparation(recipeId:Long) = {
   Call("GET", "/recipes/" + implicitly[PathBindable[Long]].unbind("recipeId", recipeId) + "/preparationStep")
}
                                                        
 
// @LINE:11
def newRecipe() = {
   Call("GET", "/recipes/new")
}
                                                        
 
// @LINE:13
def addRecipeIngredient(recipeId:Long) = {
   Call("POST", "/recipes/" + implicitly[PathBindable[Long]].unbind("recipeId", recipeId) + "/ingredients/new")
}
                                                        
 
// @LINE:22
def addPreparationStep(recipeId:Long) = {
   Call("POST", "/recipes/" + implicitly[PathBindable[Long]].unbind("recipeId", recipeId) + "/preparationStep/new")
}
                                                        
 
// @LINE:16
def updateRecipe(recipeId:Long) = {
   Call("POST", "/recipes/" + implicitly[PathBindable[Long]].unbind("recipeId", recipeId))
}
                                                        

                      
    
}
                            

// @LINE:6
class ReverseApplication {
    


 
// @LINE:6
def index() = {
   Call("GET", "/")
}
                                                        

                      
    
}
                            
}
                    


// @LINE:60
// @LINE:57
// @LINE:56
// @LINE:55
// @LINE:52
// @LINE:51
// @LINE:50
// @LINE:47
// @LINE:46
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:6
package controllers.javascript {

// @LINE:60
class ReverseAssets {
    


 
// @LINE:60
def at = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"/assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
class ReverseTagController {
    


 
// @LINE:39
def tags = JavascriptReverseRoute(
   "controllers.TagController.tags",
   """
      function() {
      return _wA({method:"GET", url:"/tags"})
      }
   """
)
                                                        
 
// @LINE:40
def tagNew = JavascriptReverseRoute(
   "controllers.TagController.tagNew",
   """
      function() {
      return _wA({method:"POST", url:"/tags/create"})
      }
   """
)
                                                        
 
// @LINE:43
def tagUpdate = JavascriptReverseRoute(
   "controllers.TagController.tagUpdate",
   """
      function(tagId) {
      return _wA({method:"POST", url:"/tags/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("tagId", tagId)})
      }
   """
)
                                                        
 
// @LINE:41
def tagRemove = JavascriptReverseRoute(
   "controllers.TagController.tagRemove",
   """
      function(tagId) {
      return _wA({method:"POST", url:"/tags/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("tagId", tagId) + "/delete"})
      }
   """
)
                                                        
 
// @LINE:42
def tagEdit = JavascriptReverseRoute(
   "controllers.TagController.tagEdit",
   """
      function(tagId) {
      return _wA({method:"GET", url:"/tags/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("tagId", tagId) + "/edit"})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
class ReverseMealController {
    


 
// @LINE:31
def mealsNew = JavascriptReverseRoute(
   "controllers.MealController.mealsNew",
   """
      function(recipeId) {
      return _wA({method:"POST", url:"/meals/create/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("recipeId", recipeId)})
      }
   """
)
                                                        
 
// @LINE:26
def meals = JavascriptReverseRoute(
   "controllers.MealController.meals",
   """
      function() {
      return _wA({method:"GET", url:"/meals"})
      }
   """
)
                                                        
 
// @LINE:33
def mealEdit = JavascriptReverseRoute(
   "controllers.MealController.mealEdit",
   """
      function(mealId) {
      return _wA({method:"GET", url:"/meals/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("mealId", mealId) + "/edit"})
      }
   """
)
                                                        
 
// @LINE:32
def mealRemove = JavascriptReverseRoute(
   "controllers.MealController.mealRemove",
   """
      function(mealId) {
      return _wA({method:"POST", url:"/meals/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("mealId", mealId) + "/delete"})
      }
   """
)
                                                        
 
// @LINE:28
def mealsNewRecipe = JavascriptReverseRoute(
   "controllers.MealController.mealsNewRecipe",
   """
      function() {
      return _wA({method:"GET", url:"/meals/create/recipe"})
      }
   """
)
                                                        
 
// @LINE:35
def mealShoppingList = JavascriptReverseRoute(
   "controllers.MealController.mealShoppingList",
   """
      function(from,to) {
      return _wA({method:"GET", url:"/meals/shoppingList/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("from", from) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("to", to)})
      }
   """
)
                                                        
 
// @LINE:34
def mealUpdate = JavascriptReverseRoute(
   "controllers.MealController.mealUpdate",
   """
      function(recipeId,mealId) {
      return _wA({method:"POST", url:"/meals/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("mealId", mealId) + "/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("recipeId", recipeId)})
      }
   """
)
                                                        
 
// @LINE:27
def mealsQuery = JavascriptReverseRoute(
   "controllers.MealController.mealsQuery",
   """
      function() {
      return _wA({method:"GET", url:"/meals/query"})
      }
   """
)
                                                        
 
// @LINE:29
def mealsNewRecipeQuery = JavascriptReverseRoute(
   "controllers.MealController.mealsNewRecipeQuery",
   """
      function() {
      return _wA({method:"GET", url:"/meals/create/recipe/query"})
      }
   """
)
                                                        
 
// @LINE:36
def mealProposal = JavascriptReverseRoute(
   "controllers.MealController.mealProposal",
   """
      function() {
      return _wA({method:"GET", url:"/meals/proposal"})
      }
   """
)
                                                        
 
// @LINE:30
def mealsNewDay = JavascriptReverseRoute(
   "controllers.MealController.mealsNewDay",
   """
      function(recipeId) {
      return _wA({method:"GET", url:"/meals/create/day/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("recipeId", recipeId)})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:52
// @LINE:51
// @LINE:50
// @LINE:19
// @LINE:18
// @LINE:10
// @LINE:9
class ReverseRecipeController {
    


 
// @LINE:19
// @LINE:18
def recipe = JavascriptReverseRoute(
   "controllers.RecipeController.recipe",
   """
      function(recipeId, page) {
      if (page == """ + implicitly[JavascriptLitteral[String]].to("all") + """) {
      return _wA({method:"GET", url:"/recipes/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("recipeId", recipeId)})
      }
      if (true) {
      return _wA({method:"GET", url:"/recipes/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("recipeId", recipeId) + "/page/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("page", page)})
      }
      }
   """
)
                                                        
 
// @LINE:9
def recipes = JavascriptReverseRoute(
   "controllers.RecipeController.recipes",
   """
      function() {
      return _wA({method:"GET", url:"/recipes"})
      }
   """
)
                                                        
 
// @LINE:10
def recipesQuery = JavascriptReverseRoute(
   "controllers.RecipeController.recipesQuery",
   """
      function() {
      return _wA({method:"GET", url:"/recipes/query"})
      }
   """
)
                                                        
 
// @LINE:51
def copyRecipeQuery = JavascriptReverseRoute(
   "controllers.RecipeController.copyRecipeQuery",
   """
      function() {
      return _wA({method:"GET", url:"/copyRecipe/query"})
      }
   """
)
                                                        
 
// @LINE:52
def copyRecipeToUser = JavascriptReverseRoute(
   "controllers.RecipeController.copyRecipeToUser",
   """
      function(recipeId) {
      return _wA({method:"POST", url:"/copyRecipe/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("recipeId", recipeId)})
      }
   """
)
                                                        
 
// @LINE:50
def copyRecipe = JavascriptReverseRoute(
   "controllers.RecipeController.copyRecipe",
   """
      function() {
      return _wA({method:"GET", url:"/copyRecipe"})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:57
// @LINE:56
// @LINE:55
class ReverseAuthenticationController {
    


 
// @LINE:56
def openIDCallback = JavascriptReverseRoute(
   "controllers.AuthenticationController.openIDCallback",
   """
      function(uri) {
      return _wA({method:"GET", url:"/openId/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("uri", uri)})
      }
   """
)
                                                        
 
// @LINE:57
def logout = JavascriptReverseRoute(
   "controllers.AuthenticationController.logout",
   """
      function() {
      return _wA({method:"GET", url:"/logout"})
      }
   """
)
                                                        
 
// @LINE:55
def login = JavascriptReverseRoute(
   "controllers.AuthenticationController.login",
   """
      function(uri) {
      return _wA({method:"GET", url:"/login/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("uri", uri)})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:47
// @LINE:46
class ReverseRecipeImport {
    


 
// @LINE:46
def importRecipe = JavascriptReverseRoute(
   "controllers.RecipeImport.importRecipe",
   """
      function() {
      return _wA({method:"GET", url:"/import"})
      }
   """
)
                                                        
 
// @LINE:47
def importRecipeWithId = JavascriptReverseRoute(
   "controllers.RecipeImport.importRecipeWithId",
   """
      function() {
      return _wA({method:"POST", url:"/import/chefkoch/"})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
class ReverseRecipeCreator {
    


 
// @LINE:15
def createRecipe = JavascriptReverseRoute(
   "controllers.RecipeCreator.createRecipe",
   """
      function() {
      return _wA({method:"POST", url:"/recipes/create"})
      }
   """
)
                                                        
 
// @LINE:17
def removeRecipe = JavascriptReverseRoute(
   "controllers.RecipeCreator.removeRecipe",
   """
      function(recipeId) {
      return _wA({method:"POST", url:"/recipes/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("recipeId", recipeId) + "/delete"})
      }
   """
)
                                                        
 
// @LINE:23
def removePreparationStep = JavascriptReverseRoute(
   "controllers.RecipeCreator.removePreparationStep",
   """
      function(recipeId,preparationStepId) {
      return _wA({method:"POST", url:"/recipes/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("recipeId", recipeId) + "/preparationStep/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("preparationStepId", preparationStepId) + "/delete"})
      }
   """
)
                                                        
 
// @LINE:14
def removeRecipeIngredient = JavascriptReverseRoute(
   "controllers.RecipeCreator.removeRecipeIngredient",
   """
      function(recipeId,ingredientId) {
      return _wA({method:"POST", url:"/recipes/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("recipeId", recipeId) + "/ingredients/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("ingredientId", ingredientId) + "/delete"})
      }
   """
)
                                                        
 
// @LINE:20
def editRecipe = JavascriptReverseRoute(
   "controllers.RecipeCreator.editRecipe",
   """
      function(recipeId) {
      return _wA({method:"GET", url:"/recipes/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("recipeId", recipeId) + "/edit"})
      }
   """
)
                                                        
 
// @LINE:12
def recipeIngredients = JavascriptReverseRoute(
   "controllers.RecipeCreator.recipeIngredients",
   """
      function(recipeId) {
      return _wA({method:"GET", url:"/recipes/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("recipeId", recipeId) + "/ingredients"})
      }
   """
)
                                                        
 
// @LINE:21
def recipePreparation = JavascriptReverseRoute(
   "controllers.RecipeCreator.recipePreparation",
   """
      function(recipeId) {
      return _wA({method:"GET", url:"/recipes/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("recipeId", recipeId) + "/preparationStep"})
      }
   """
)
                                                        
 
// @LINE:11
def newRecipe = JavascriptReverseRoute(
   "controllers.RecipeCreator.newRecipe",
   """
      function() {
      return _wA({method:"GET", url:"/recipes/new"})
      }
   """
)
                                                        
 
// @LINE:13
def addRecipeIngredient = JavascriptReverseRoute(
   "controllers.RecipeCreator.addRecipeIngredient",
   """
      function(recipeId) {
      return _wA({method:"POST", url:"/recipes/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("recipeId", recipeId) + "/ingredients/new"})
      }
   """
)
                                                        
 
// @LINE:22
def addPreparationStep = JavascriptReverseRoute(
   "controllers.RecipeCreator.addPreparationStep",
   """
      function(recipeId) {
      return _wA({method:"POST", url:"/recipes/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("recipeId", recipeId) + "/preparationStep/new"})
      }
   """
)
                                                        
 
// @LINE:16
def updateRecipe = JavascriptReverseRoute(
   "controllers.RecipeCreator.updateRecipe",
   """
      function(recipeId) {
      return _wA({method:"POST", url:"/recipes/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("recipeId", recipeId)})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:6
class ReverseApplication {
    


 
// @LINE:6
def index = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"/"})
      }
   """
)
                                                        

                      
    
}
                            
}
                    


// @LINE:60
// @LINE:57
// @LINE:56
// @LINE:55
// @LINE:52
// @LINE:51
// @LINE:50
// @LINE:47
// @LINE:46
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:6
package controllers.ref {

// @LINE:60
class ReverseAssets {
    


 
// @LINE:60
def at(path:String, file:String) = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]))
)
                              

                      
    
}
                            

// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
class ReverseTagController {
    


 
// @LINE:39
def tags() = new play.api.mvc.HandlerRef(
   controllers.TagController.tags(), HandlerDef(this, "controllers.TagController", "tags", Seq())
)
                              
 
// @LINE:40
def tagNew() = new play.api.mvc.HandlerRef(
   controllers.TagController.tagNew(), HandlerDef(this, "controllers.TagController", "tagNew", Seq())
)
                              
 
// @LINE:43
def tagUpdate(tagId:Long) = new play.api.mvc.HandlerRef(
   controllers.TagController.tagUpdate(tagId), HandlerDef(this, "controllers.TagController", "tagUpdate", Seq(classOf[Long]))
)
                              
 
// @LINE:41
def tagRemove(tagId:Long) = new play.api.mvc.HandlerRef(
   controllers.TagController.tagRemove(tagId), HandlerDef(this, "controllers.TagController", "tagRemove", Seq(classOf[Long]))
)
                              
 
// @LINE:42
def tagEdit(tagId:Long) = new play.api.mvc.HandlerRef(
   controllers.TagController.tagEdit(tagId), HandlerDef(this, "controllers.TagController", "tagEdit", Seq(classOf[Long]))
)
                              

                      
    
}
                            

// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
class ReverseMealController {
    


 
// @LINE:31
def mealsNew(recipeId:Long) = new play.api.mvc.HandlerRef(
   controllers.MealController.mealsNew(recipeId), HandlerDef(this, "controllers.MealController", "mealsNew", Seq(classOf[Long]))
)
                              
 
// @LINE:26
def meals() = new play.api.mvc.HandlerRef(
   controllers.MealController.meals(), HandlerDef(this, "controllers.MealController", "meals", Seq())
)
                              
 
// @LINE:33
def mealEdit(mealId:Long) = new play.api.mvc.HandlerRef(
   controllers.MealController.mealEdit(mealId), HandlerDef(this, "controllers.MealController", "mealEdit", Seq(classOf[Long]))
)
                              
 
// @LINE:32
def mealRemove(mealId:Long) = new play.api.mvc.HandlerRef(
   controllers.MealController.mealRemove(mealId), HandlerDef(this, "controllers.MealController", "mealRemove", Seq(classOf[Long]))
)
                              
 
// @LINE:28
def mealsNewRecipe() = new play.api.mvc.HandlerRef(
   controllers.MealController.mealsNewRecipe(), HandlerDef(this, "controllers.MealController", "mealsNewRecipe", Seq())
)
                              
 
// @LINE:35
def mealShoppingList(from:String, to:String) = new play.api.mvc.HandlerRef(
   controllers.MealController.mealShoppingList(from, to), HandlerDef(this, "controllers.MealController", "mealShoppingList", Seq(classOf[String], classOf[String]))
)
                              
 
// @LINE:34
def mealUpdate(recipeId:Long, mealId:Long) = new play.api.mvc.HandlerRef(
   controllers.MealController.mealUpdate(recipeId, mealId), HandlerDef(this, "controllers.MealController", "mealUpdate", Seq(classOf[Long], classOf[Long]))
)
                              
 
// @LINE:27
def mealsQuery() = new play.api.mvc.HandlerRef(
   controllers.MealController.mealsQuery(), HandlerDef(this, "controllers.MealController", "mealsQuery", Seq())
)
                              
 
// @LINE:29
def mealsNewRecipeQuery() = new play.api.mvc.HandlerRef(
   controllers.MealController.mealsNewRecipeQuery(), HandlerDef(this, "controllers.MealController", "mealsNewRecipeQuery", Seq())
)
                              
 
// @LINE:36
def mealProposal() = new play.api.mvc.HandlerRef(
   controllers.MealController.mealProposal(), HandlerDef(this, "controllers.MealController", "mealProposal", Seq())
)
                              
 
// @LINE:30
def mealsNewDay(recipeId:Long) = new play.api.mvc.HandlerRef(
   controllers.MealController.mealsNewDay(recipeId), HandlerDef(this, "controllers.MealController", "mealsNewDay", Seq(classOf[Long]))
)
                              

                      
    
}
                            

// @LINE:52
// @LINE:51
// @LINE:50
// @LINE:19
// @LINE:18
// @LINE:10
// @LINE:9
class ReverseRecipeController {
    


 
// @LINE:18
def recipe(recipeId:Long, page:String) = new play.api.mvc.HandlerRef(
   controllers.RecipeController.recipe(recipeId, page), HandlerDef(this, "controllers.RecipeController", "recipe", Seq(classOf[Long], classOf[String]))
)
                              
 
// @LINE:9
def recipes() = new play.api.mvc.HandlerRef(
   controllers.RecipeController.recipes(), HandlerDef(this, "controllers.RecipeController", "recipes", Seq())
)
                              
 
// @LINE:10
def recipesQuery() = new play.api.mvc.HandlerRef(
   controllers.RecipeController.recipesQuery(), HandlerDef(this, "controllers.RecipeController", "recipesQuery", Seq())
)
                              
 
// @LINE:51
def copyRecipeQuery() = new play.api.mvc.HandlerRef(
   controllers.RecipeController.copyRecipeQuery(), HandlerDef(this, "controllers.RecipeController", "copyRecipeQuery", Seq())
)
                              
 
// @LINE:52
def copyRecipeToUser(recipeId:Long) = new play.api.mvc.HandlerRef(
   controllers.RecipeController.copyRecipeToUser(recipeId), HandlerDef(this, "controllers.RecipeController", "copyRecipeToUser", Seq(classOf[Long]))
)
                              
 
// @LINE:50
def copyRecipe() = new play.api.mvc.HandlerRef(
   controllers.RecipeController.copyRecipe(), HandlerDef(this, "controllers.RecipeController", "copyRecipe", Seq())
)
                              

                      
    
}
                            

// @LINE:57
// @LINE:56
// @LINE:55
class ReverseAuthenticationController {
    


 
// @LINE:56
def openIDCallback(uri:String) = new play.api.mvc.HandlerRef(
   controllers.AuthenticationController.openIDCallback(uri), HandlerDef(this, "controllers.AuthenticationController", "openIDCallback", Seq(classOf[String]))
)
                              
 
// @LINE:57
def logout() = new play.api.mvc.HandlerRef(
   controllers.AuthenticationController.logout(), HandlerDef(this, "controllers.AuthenticationController", "logout", Seq())
)
                              
 
// @LINE:55
def login(uri:String) = new play.api.mvc.HandlerRef(
   controllers.AuthenticationController.login(uri), HandlerDef(this, "controllers.AuthenticationController", "login", Seq(classOf[String]))
)
                              

                      
    
}
                            

// @LINE:47
// @LINE:46
class ReverseRecipeImport {
    


 
// @LINE:46
def importRecipe() = new play.api.mvc.HandlerRef(
   controllers.RecipeImport.importRecipe(), HandlerDef(this, "controllers.RecipeImport", "importRecipe", Seq())
)
                              
 
// @LINE:47
def importRecipeWithId() = new play.api.mvc.HandlerRef(
   controllers.RecipeImport.importRecipeWithId(), HandlerDef(this, "controllers.RecipeImport", "importRecipeWithId", Seq())
)
                              

                      
    
}
                            

// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
class ReverseRecipeCreator {
    


 
// @LINE:15
def createRecipe() = new play.api.mvc.HandlerRef(
   controllers.RecipeCreator.createRecipe(), HandlerDef(this, "controllers.RecipeCreator", "createRecipe", Seq())
)
                              
 
// @LINE:17
def removeRecipe(recipeId:Long) = new play.api.mvc.HandlerRef(
   controllers.RecipeCreator.removeRecipe(recipeId), HandlerDef(this, "controllers.RecipeCreator", "removeRecipe", Seq(classOf[Long]))
)
                              
 
// @LINE:23
def removePreparationStep(recipeId:Long, preparationStepId:Long) = new play.api.mvc.HandlerRef(
   controllers.RecipeCreator.removePreparationStep(recipeId, preparationStepId), HandlerDef(this, "controllers.RecipeCreator", "removePreparationStep", Seq(classOf[Long], classOf[Long]))
)
                              
 
// @LINE:14
def removeRecipeIngredient(recipeId:Long, ingredientId:Long) = new play.api.mvc.HandlerRef(
   controllers.RecipeCreator.removeRecipeIngredient(recipeId, ingredientId), HandlerDef(this, "controllers.RecipeCreator", "removeRecipeIngredient", Seq(classOf[Long], classOf[Long]))
)
                              
 
// @LINE:20
def editRecipe(recipeId:Long) = new play.api.mvc.HandlerRef(
   controllers.RecipeCreator.editRecipe(recipeId), HandlerDef(this, "controllers.RecipeCreator", "editRecipe", Seq(classOf[Long]))
)
                              
 
// @LINE:12
def recipeIngredients(recipeId:Long) = new play.api.mvc.HandlerRef(
   controllers.RecipeCreator.recipeIngredients(recipeId), HandlerDef(this, "controllers.RecipeCreator", "recipeIngredients", Seq(classOf[Long]))
)
                              
 
// @LINE:21
def recipePreparation(recipeId:Long) = new play.api.mvc.HandlerRef(
   controllers.RecipeCreator.recipePreparation(recipeId), HandlerDef(this, "controllers.RecipeCreator", "recipePreparation", Seq(classOf[Long]))
)
                              
 
// @LINE:11
def newRecipe() = new play.api.mvc.HandlerRef(
   controllers.RecipeCreator.newRecipe(), HandlerDef(this, "controllers.RecipeCreator", "newRecipe", Seq())
)
                              
 
// @LINE:13
def addRecipeIngredient(recipeId:Long) = new play.api.mvc.HandlerRef(
   controllers.RecipeCreator.addRecipeIngredient(recipeId), HandlerDef(this, "controllers.RecipeCreator", "addRecipeIngredient", Seq(classOf[Long]))
)
                              
 
// @LINE:22
def addPreparationStep(recipeId:Long) = new play.api.mvc.HandlerRef(
   controllers.RecipeCreator.addPreparationStep(recipeId), HandlerDef(this, "controllers.RecipeCreator", "addPreparationStep", Seq(classOf[Long]))
)
                              
 
// @LINE:16
def updateRecipe(recipeId:Long) = new play.api.mvc.HandlerRef(
   controllers.RecipeCreator.updateRecipe(recipeId), HandlerDef(this, "controllers.RecipeCreator", "updateRecipe", Seq(classOf[Long]))
)
                              

                      
    
}
                            

// @LINE:6
class ReverseApplication {
    


 
// @LINE:6
def index() = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq())
)
                              

                      
    
}
                            
}
                    
                