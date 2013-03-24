// @SOURCE:E:/Eigene Dateien/workspace-scala/essensplan/conf/routes
// @HASH:2005fe15ec47e6c48dd956f004d5774a1df1a4e3
// @DATE:Sun Mar 24 11:08:59 CET 2013

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
class ReverseApplication {
    


 
// @LINE:31
def mealsNew(recipeId:Long) = {
   Call("POST", "/meals/create/" + implicitly[PathBindable[Long]].unbind("recipeId", recipeId))
}
                                                        
 
// @LINE:26
def meals() = {
   Call("GET", "/meals")
}
                                                        
 
// @LINE:47
def importRecipeWithId() = {
   Call("POST", "/import/chefkoch/")
}
                                                        
 
// @LINE:15
def createRecipe() = {
   Call("POST", "/recipes/create")
}
                                                        
 
// @LINE:46
def importRecipe() = {
   Call("GET", "/import")
}
                                                        
 
// @LINE:33
def mealEdit(mealId:Long) = {
   Call("GET", "/meals/" + implicitly[PathBindable[Long]].unbind("mealId", mealId) + "/edit")
}
                                                        
 
// @LINE:55
def login() = {
   Call("GET", "/login")
}
                                                        
 
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
                                                        
 
// @LINE:17
def removeRecipe(recipeId:Long) = {
   Call("POST", "/recipes/" + implicitly[PathBindable[Long]].unbind("recipeId", recipeId) + "/delete")
}
                                                        
 
// @LINE:39
def tags() = {
   Call("GET", "/tags")
}
                                                        
 
// @LINE:32
def mealRemove(mealId:Long) = {
   Call("POST", "/meals/" + implicitly[PathBindable[Long]].unbind("mealId", mealId) + "/delete")
}
                                                        
 
// @LINE:57
def logout() = {
   Call("GET", "/logout")
}
                                                        
 
// @LINE:23
def removePreparationStep(recipeId:Long, preparationStepId:Long) = {
   Call("POST", "/recipes/" + implicitly[PathBindable[Long]].unbind("recipeId", recipeId) + "/preparationStep/" + implicitly[PathBindable[Long]].unbind("preparationStepId", preparationStepId) + "/delete")
}
                                                        
 
// @LINE:28
def mealsNewRecipe() = {
   Call("GET", "/meals/create/recipe")
}
                                                        
 
// @LINE:9
def recipes() = {
   Call("GET", "/recipes")
}
                                                        
 
// @LINE:56
def openIDCallback() = {
   Call("GET", "/login/openId")
}
                                                        
 
// @LINE:35
def mealShoppingList(from:String, to:String) = {
   Call("GET", "/meals/shoppingList/" + implicitly[PathBindable[String]].unbind("from", from) + "/" + implicitly[PathBindable[String]].unbind("to", to))
}
                                                        
 
// @LINE:14
def removeRecipeIngredient(recipeId:Long, ingredientId:Long) = {
   Call("POST", "/recipes/" + implicitly[PathBindable[Long]].unbind("recipeId", recipeId) + "/ingredients/" + implicitly[PathBindable[Long]].unbind("ingredientId", ingredientId) + "/delete")
}
                                                        
 
// @LINE:20
def editRecipe(recipeId:Long) = {
   Call("GET", "/recipes/" + implicitly[PathBindable[Long]].unbind("recipeId", recipeId) + "/edit")
}
                                                        
 
// @LINE:10
def recipesQuery() = {
   Call("GET", "/recipes/query")
}
                                                        
 
// @LINE:12
def recipeIngredients(recipeId:Long) = {
   Call("GET", "/recipes/" + implicitly[PathBindable[Long]].unbind("recipeId", recipeId) + "/ingredients")
}
                                                        
 
// @LINE:40
def tagNew() = {
   Call("POST", "/tags/create")
}
                                                        
 
// @LINE:21
def recipePreparation(recipeId:Long) = {
   Call("GET", "/recipes/" + implicitly[PathBindable[Long]].unbind("recipeId", recipeId) + "/preparationStep")
}
                                                        
 
// @LINE:43
def tagUpdate(tagId:Long) = {
   Call("POST", "/tags/" + implicitly[PathBindable[Long]].unbind("tagId", tagId))
}
                                                        
 
// @LINE:11
def newRecipe() = {
   Call("GET", "/recipes/new")
}
                                                        
 
// @LINE:6
def index() = {
   Call("GET", "/")
}
                                                        
 
// @LINE:51
def copyRecipeQuery() = {
   Call("GET", "/copyRecipe/query")
}
                                                        
 
// @LINE:41
def tagRemove(tagId:Long) = {
   Call("POST", "/tags/" + implicitly[PathBindable[Long]].unbind("tagId", tagId) + "/delete")
}
                                                        
 
// @LINE:13
def addRecipeIngredient(recipeId:Long) = {
   Call("POST", "/recipes/" + implicitly[PathBindable[Long]].unbind("recipeId", recipeId) + "/ingredients/new")
}
                                                        
 
// @LINE:42
def tagEdit(tagId:Long) = {
   Call("GET", "/tags/" + implicitly[PathBindable[Long]].unbind("tagId", tagId) + "/edit")
}
                                                        
 
// @LINE:22
def addPreparationStep(recipeId:Long) = {
   Call("POST", "/recipes/" + implicitly[PathBindable[Long]].unbind("recipeId", recipeId) + "/preparationStep/new")
}
                                                        
 
// @LINE:34
def mealUpdate(recipeId:Long, mealId:Long) = {
   Call("POST", "/meals/" + implicitly[PathBindable[Long]].unbind("mealId", mealId) + "/" + implicitly[PathBindable[Long]].unbind("recipeId", recipeId))
}
                                                        
 
// @LINE:27
def mealsQuery() = {
   Call("GET", "/meals/query")
}
                                                        
 
// @LINE:52
def copyRecipeToUser(recipeId:Long) = {
   Call("POST", "/copyRecipe/" + implicitly[PathBindable[Long]].unbind("recipeId", recipeId))
}
                                                        
 
// @LINE:50
def copyRecipe() = {
   Call("GET", "/copyRecipe")
}
                                                        
 
// @LINE:29
def mealsNewRecipeQuery() = {
   Call("GET", "/meals/create/recipe/query")
}
                                                        
 
// @LINE:16
def updateRecipe(recipeId:Long) = {
   Call("POST", "/recipes/" + implicitly[PathBindable[Long]].unbind("recipeId", recipeId))
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
                            

// @LINE:60
class ReverseAssets {
    


 
// @LINE:60
def at(file:String) = {
   Call("GET", "/assets/" + implicitly[PathBindable[String]].unbind("file", file))
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
class ReverseApplication {
    


 
// @LINE:31
def mealsNew = JavascriptReverseRoute(
   "controllers.Application.mealsNew",
   """
      function(recipeId) {
      return _wA({method:"POST", url:"/meals/create/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("recipeId", recipeId)})
      }
   """
)
                                                        
 
// @LINE:26
def meals = JavascriptReverseRoute(
   "controllers.Application.meals",
   """
      function() {
      return _wA({method:"GET", url:"/meals"})
      }
   """
)
                                                        
 
// @LINE:47
def importRecipeWithId = JavascriptReverseRoute(
   "controllers.Application.importRecipeWithId",
   """
      function() {
      return _wA({method:"POST", url:"/import/chefkoch/"})
      }
   """
)
                                                        
 
// @LINE:15
def createRecipe = JavascriptReverseRoute(
   "controllers.Application.createRecipe",
   """
      function() {
      return _wA({method:"POST", url:"/recipes/create"})
      }
   """
)
                                                        
 
// @LINE:46
def importRecipe = JavascriptReverseRoute(
   "controllers.Application.importRecipe",
   """
      function() {
      return _wA({method:"GET", url:"/import"})
      }
   """
)
                                                        
 
// @LINE:33
def mealEdit = JavascriptReverseRoute(
   "controllers.Application.mealEdit",
   """
      function(mealId) {
      return _wA({method:"GET", url:"/meals/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("mealId", mealId) + "/edit"})
      }
   """
)
                                                        
 
// @LINE:55
def login = JavascriptReverseRoute(
   "controllers.Application.login",
   """
      function() {
      return _wA({method:"GET", url:"/login"})
      }
   """
)
                                                        
 
// @LINE:19
// @LINE:18
def recipe = JavascriptReverseRoute(
   "controllers.Application.recipe",
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
                                                        
 
// @LINE:17
def removeRecipe = JavascriptReverseRoute(
   "controllers.Application.removeRecipe",
   """
      function(recipeId) {
      return _wA({method:"POST", url:"/recipes/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("recipeId", recipeId) + "/delete"})
      }
   """
)
                                                        
 
// @LINE:39
def tags = JavascriptReverseRoute(
   "controllers.Application.tags",
   """
      function() {
      return _wA({method:"GET", url:"/tags"})
      }
   """
)
                                                        
 
// @LINE:32
def mealRemove = JavascriptReverseRoute(
   "controllers.Application.mealRemove",
   """
      function(mealId) {
      return _wA({method:"POST", url:"/meals/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("mealId", mealId) + "/delete"})
      }
   """
)
                                                        
 
// @LINE:57
def logout = JavascriptReverseRoute(
   "controllers.Application.logout",
   """
      function() {
      return _wA({method:"GET", url:"/logout"})
      }
   """
)
                                                        
 
// @LINE:23
def removePreparationStep = JavascriptReverseRoute(
   "controllers.Application.removePreparationStep",
   """
      function(recipeId,preparationStepId) {
      return _wA({method:"POST", url:"/recipes/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("recipeId", recipeId) + "/preparationStep/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("preparationStepId", preparationStepId) + "/delete"})
      }
   """
)
                                                        
 
// @LINE:28
def mealsNewRecipe = JavascriptReverseRoute(
   "controllers.Application.mealsNewRecipe",
   """
      function() {
      return _wA({method:"GET", url:"/meals/create/recipe"})
      }
   """
)
                                                        
 
// @LINE:9
def recipes = JavascriptReverseRoute(
   "controllers.Application.recipes",
   """
      function() {
      return _wA({method:"GET", url:"/recipes"})
      }
   """
)
                                                        
 
// @LINE:56
def openIDCallback = JavascriptReverseRoute(
   "controllers.Application.openIDCallback",
   """
      function() {
      return _wA({method:"GET", url:"/login/openId"})
      }
   """
)
                                                        
 
// @LINE:35
def mealShoppingList = JavascriptReverseRoute(
   "controllers.Application.mealShoppingList",
   """
      function(from,to) {
      return _wA({method:"GET", url:"/meals/shoppingList/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("from", from) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("to", to)})
      }
   """
)
                                                        
 
// @LINE:14
def removeRecipeIngredient = JavascriptReverseRoute(
   "controllers.Application.removeRecipeIngredient",
   """
      function(recipeId,ingredientId) {
      return _wA({method:"POST", url:"/recipes/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("recipeId", recipeId) + "/ingredients/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("ingredientId", ingredientId) + "/delete"})
      }
   """
)
                                                        
 
// @LINE:20
def editRecipe = JavascriptReverseRoute(
   "controllers.Application.editRecipe",
   """
      function(recipeId) {
      return _wA({method:"GET", url:"/recipes/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("recipeId", recipeId) + "/edit"})
      }
   """
)
                                                        
 
// @LINE:10
def recipesQuery = JavascriptReverseRoute(
   "controllers.Application.recipesQuery",
   """
      function() {
      return _wA({method:"GET", url:"/recipes/query"})
      }
   """
)
                                                        
 
// @LINE:12
def recipeIngredients = JavascriptReverseRoute(
   "controllers.Application.recipeIngredients",
   """
      function(recipeId) {
      return _wA({method:"GET", url:"/recipes/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("recipeId", recipeId) + "/ingredients"})
      }
   """
)
                                                        
 
// @LINE:40
def tagNew = JavascriptReverseRoute(
   "controllers.Application.tagNew",
   """
      function() {
      return _wA({method:"POST", url:"/tags/create"})
      }
   """
)
                                                        
 
// @LINE:21
def recipePreparation = JavascriptReverseRoute(
   "controllers.Application.recipePreparation",
   """
      function(recipeId) {
      return _wA({method:"GET", url:"/recipes/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("recipeId", recipeId) + "/preparationStep"})
      }
   """
)
                                                        
 
// @LINE:43
def tagUpdate = JavascriptReverseRoute(
   "controllers.Application.tagUpdate",
   """
      function(tagId) {
      return _wA({method:"POST", url:"/tags/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("tagId", tagId)})
      }
   """
)
                                                        
 
// @LINE:11
def newRecipe = JavascriptReverseRoute(
   "controllers.Application.newRecipe",
   """
      function() {
      return _wA({method:"GET", url:"/recipes/new"})
      }
   """
)
                                                        
 
// @LINE:6
def index = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"/"})
      }
   """
)
                                                        
 
// @LINE:51
def copyRecipeQuery = JavascriptReverseRoute(
   "controllers.Application.copyRecipeQuery",
   """
      function() {
      return _wA({method:"GET", url:"/copyRecipe/query"})
      }
   """
)
                                                        
 
// @LINE:41
def tagRemove = JavascriptReverseRoute(
   "controllers.Application.tagRemove",
   """
      function(tagId) {
      return _wA({method:"POST", url:"/tags/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("tagId", tagId) + "/delete"})
      }
   """
)
                                                        
 
// @LINE:13
def addRecipeIngredient = JavascriptReverseRoute(
   "controllers.Application.addRecipeIngredient",
   """
      function(recipeId) {
      return _wA({method:"POST", url:"/recipes/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("recipeId", recipeId) + "/ingredients/new"})
      }
   """
)
                                                        
 
// @LINE:42
def tagEdit = JavascriptReverseRoute(
   "controllers.Application.tagEdit",
   """
      function(tagId) {
      return _wA({method:"GET", url:"/tags/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("tagId", tagId) + "/edit"})
      }
   """
)
                                                        
 
// @LINE:22
def addPreparationStep = JavascriptReverseRoute(
   "controllers.Application.addPreparationStep",
   """
      function(recipeId) {
      return _wA({method:"POST", url:"/recipes/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("recipeId", recipeId) + "/preparationStep/new"})
      }
   """
)
                                                        
 
// @LINE:34
def mealUpdate = JavascriptReverseRoute(
   "controllers.Application.mealUpdate",
   """
      function(recipeId,mealId) {
      return _wA({method:"POST", url:"/meals/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("mealId", mealId) + "/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("recipeId", recipeId)})
      }
   """
)
                                                        
 
// @LINE:27
def mealsQuery = JavascriptReverseRoute(
   "controllers.Application.mealsQuery",
   """
      function() {
      return _wA({method:"GET", url:"/meals/query"})
      }
   """
)
                                                        
 
// @LINE:52
def copyRecipeToUser = JavascriptReverseRoute(
   "controllers.Application.copyRecipeToUser",
   """
      function(recipeId) {
      return _wA({method:"POST", url:"/copyRecipe/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("recipeId", recipeId)})
      }
   """
)
                                                        
 
// @LINE:50
def copyRecipe = JavascriptReverseRoute(
   "controllers.Application.copyRecipe",
   """
      function() {
      return _wA({method:"GET", url:"/copyRecipe"})
      }
   """
)
                                                        
 
// @LINE:29
def mealsNewRecipeQuery = JavascriptReverseRoute(
   "controllers.Application.mealsNewRecipeQuery",
   """
      function() {
      return _wA({method:"GET", url:"/meals/create/recipe/query"})
      }
   """
)
                                                        
 
// @LINE:16
def updateRecipe = JavascriptReverseRoute(
   "controllers.Application.updateRecipe",
   """
      function(recipeId) {
      return _wA({method:"POST", url:"/recipes/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("recipeId", recipeId)})
      }
   """
)
                                                        
 
// @LINE:36
def mealProposal = JavascriptReverseRoute(
   "controllers.Application.mealProposal",
   """
      function() {
      return _wA({method:"GET", url:"/meals/proposal"})
      }
   """
)
                                                        
 
// @LINE:30
def mealsNewDay = JavascriptReverseRoute(
   "controllers.Application.mealsNewDay",
   """
      function(recipeId) {
      return _wA({method:"GET", url:"/meals/create/day/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("recipeId", recipeId)})
      }
   """
)
                                                        

                      
    
}
                            

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
class ReverseApplication {
    


 
// @LINE:31
def mealsNew(recipeId:Long) = new play.api.mvc.HandlerRef(
   controllers.Application.mealsNew(recipeId), HandlerDef(this, "controllers.Application", "mealsNew", Seq(classOf[Long]))
)
                              
 
// @LINE:26
def meals() = new play.api.mvc.HandlerRef(
   controllers.Application.meals(), HandlerDef(this, "controllers.Application", "meals", Seq())
)
                              
 
// @LINE:47
def importRecipeWithId() = new play.api.mvc.HandlerRef(
   controllers.Application.importRecipeWithId(), HandlerDef(this, "controllers.Application", "importRecipeWithId", Seq())
)
                              
 
// @LINE:15
def createRecipe() = new play.api.mvc.HandlerRef(
   controllers.Application.createRecipe(), HandlerDef(this, "controllers.Application", "createRecipe", Seq())
)
                              
 
// @LINE:46
def importRecipe() = new play.api.mvc.HandlerRef(
   controllers.Application.importRecipe(), HandlerDef(this, "controllers.Application", "importRecipe", Seq())
)
                              
 
// @LINE:33
def mealEdit(mealId:Long) = new play.api.mvc.HandlerRef(
   controllers.Application.mealEdit(mealId), HandlerDef(this, "controllers.Application", "mealEdit", Seq(classOf[Long]))
)
                              
 
// @LINE:55
def login() = new play.api.mvc.HandlerRef(
   controllers.Application.login(), HandlerDef(this, "controllers.Application", "login", Seq())
)
                              
 
// @LINE:18
def recipe(recipeId:Long, page:String) = new play.api.mvc.HandlerRef(
   controllers.Application.recipe(recipeId, page), HandlerDef(this, "controllers.Application", "recipe", Seq(classOf[Long], classOf[String]))
)
                              
 
// @LINE:17
def removeRecipe(recipeId:Long) = new play.api.mvc.HandlerRef(
   controllers.Application.removeRecipe(recipeId), HandlerDef(this, "controllers.Application", "removeRecipe", Seq(classOf[Long]))
)
                              
 
// @LINE:39
def tags() = new play.api.mvc.HandlerRef(
   controllers.Application.tags(), HandlerDef(this, "controllers.Application", "tags", Seq())
)
                              
 
// @LINE:32
def mealRemove(mealId:Long) = new play.api.mvc.HandlerRef(
   controllers.Application.mealRemove(mealId), HandlerDef(this, "controllers.Application", "mealRemove", Seq(classOf[Long]))
)
                              
 
// @LINE:57
def logout() = new play.api.mvc.HandlerRef(
   controllers.Application.logout(), HandlerDef(this, "controllers.Application", "logout", Seq())
)
                              
 
// @LINE:23
def removePreparationStep(recipeId:Long, preparationStepId:Long) = new play.api.mvc.HandlerRef(
   controllers.Application.removePreparationStep(recipeId, preparationStepId), HandlerDef(this, "controllers.Application", "removePreparationStep", Seq(classOf[Long], classOf[Long]))
)
                              
 
// @LINE:28
def mealsNewRecipe() = new play.api.mvc.HandlerRef(
   controllers.Application.mealsNewRecipe(), HandlerDef(this, "controllers.Application", "mealsNewRecipe", Seq())
)
                              
 
// @LINE:9
def recipes() = new play.api.mvc.HandlerRef(
   controllers.Application.recipes(), HandlerDef(this, "controllers.Application", "recipes", Seq())
)
                              
 
// @LINE:56
def openIDCallback() = new play.api.mvc.HandlerRef(
   controllers.Application.openIDCallback(), HandlerDef(this, "controllers.Application", "openIDCallback", Seq())
)
                              
 
// @LINE:35
def mealShoppingList(from:String, to:String) = new play.api.mvc.HandlerRef(
   controllers.Application.mealShoppingList(from, to), HandlerDef(this, "controllers.Application", "mealShoppingList", Seq(classOf[String], classOf[String]))
)
                              
 
// @LINE:14
def removeRecipeIngredient(recipeId:Long, ingredientId:Long) = new play.api.mvc.HandlerRef(
   controllers.Application.removeRecipeIngredient(recipeId, ingredientId), HandlerDef(this, "controllers.Application", "removeRecipeIngredient", Seq(classOf[Long], classOf[Long]))
)
                              
 
// @LINE:20
def editRecipe(recipeId:Long) = new play.api.mvc.HandlerRef(
   controllers.Application.editRecipe(recipeId), HandlerDef(this, "controllers.Application", "editRecipe", Seq(classOf[Long]))
)
                              
 
// @LINE:10
def recipesQuery() = new play.api.mvc.HandlerRef(
   controllers.Application.recipesQuery(), HandlerDef(this, "controllers.Application", "recipesQuery", Seq())
)
                              
 
// @LINE:12
def recipeIngredients(recipeId:Long) = new play.api.mvc.HandlerRef(
   controllers.Application.recipeIngredients(recipeId), HandlerDef(this, "controllers.Application", "recipeIngredients", Seq(classOf[Long]))
)
                              
 
// @LINE:40
def tagNew() = new play.api.mvc.HandlerRef(
   controllers.Application.tagNew(), HandlerDef(this, "controllers.Application", "tagNew", Seq())
)
                              
 
// @LINE:21
def recipePreparation(recipeId:Long) = new play.api.mvc.HandlerRef(
   controllers.Application.recipePreparation(recipeId), HandlerDef(this, "controllers.Application", "recipePreparation", Seq(classOf[Long]))
)
                              
 
// @LINE:43
def tagUpdate(tagId:Long) = new play.api.mvc.HandlerRef(
   controllers.Application.tagUpdate(tagId), HandlerDef(this, "controllers.Application", "tagUpdate", Seq(classOf[Long]))
)
                              
 
// @LINE:11
def newRecipe() = new play.api.mvc.HandlerRef(
   controllers.Application.newRecipe(), HandlerDef(this, "controllers.Application", "newRecipe", Seq())
)
                              
 
// @LINE:6
def index() = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq())
)
                              
 
// @LINE:51
def copyRecipeQuery() = new play.api.mvc.HandlerRef(
   controllers.Application.copyRecipeQuery(), HandlerDef(this, "controllers.Application", "copyRecipeQuery", Seq())
)
                              
 
// @LINE:41
def tagRemove(tagId:Long) = new play.api.mvc.HandlerRef(
   controllers.Application.tagRemove(tagId), HandlerDef(this, "controllers.Application", "tagRemove", Seq(classOf[Long]))
)
                              
 
// @LINE:13
def addRecipeIngredient(recipeId:Long) = new play.api.mvc.HandlerRef(
   controllers.Application.addRecipeIngredient(recipeId), HandlerDef(this, "controllers.Application", "addRecipeIngredient", Seq(classOf[Long]))
)
                              
 
// @LINE:42
def tagEdit(tagId:Long) = new play.api.mvc.HandlerRef(
   controllers.Application.tagEdit(tagId), HandlerDef(this, "controllers.Application", "tagEdit", Seq(classOf[Long]))
)
                              
 
// @LINE:22
def addPreparationStep(recipeId:Long) = new play.api.mvc.HandlerRef(
   controllers.Application.addPreparationStep(recipeId), HandlerDef(this, "controllers.Application", "addPreparationStep", Seq(classOf[Long]))
)
                              
 
// @LINE:34
def mealUpdate(recipeId:Long, mealId:Long) = new play.api.mvc.HandlerRef(
   controllers.Application.mealUpdate(recipeId, mealId), HandlerDef(this, "controllers.Application", "mealUpdate", Seq(classOf[Long], classOf[Long]))
)
                              
 
// @LINE:27
def mealsQuery() = new play.api.mvc.HandlerRef(
   controllers.Application.mealsQuery(), HandlerDef(this, "controllers.Application", "mealsQuery", Seq())
)
                              
 
// @LINE:52
def copyRecipeToUser(recipeId:Long) = new play.api.mvc.HandlerRef(
   controllers.Application.copyRecipeToUser(recipeId), HandlerDef(this, "controllers.Application", "copyRecipeToUser", Seq(classOf[Long]))
)
                              
 
// @LINE:50
def copyRecipe() = new play.api.mvc.HandlerRef(
   controllers.Application.copyRecipe(), HandlerDef(this, "controllers.Application", "copyRecipe", Seq())
)
                              
 
// @LINE:29
def mealsNewRecipeQuery() = new play.api.mvc.HandlerRef(
   controllers.Application.mealsNewRecipeQuery(), HandlerDef(this, "controllers.Application", "mealsNewRecipeQuery", Seq())
)
                              
 
// @LINE:16
def updateRecipe(recipeId:Long) = new play.api.mvc.HandlerRef(
   controllers.Application.updateRecipe(recipeId), HandlerDef(this, "controllers.Application", "updateRecipe", Seq(classOf[Long]))
)
                              
 
// @LINE:36
def mealProposal() = new play.api.mvc.HandlerRef(
   controllers.Application.mealProposal(), HandlerDef(this, "controllers.Application", "mealProposal", Seq())
)
                              
 
// @LINE:30
def mealsNewDay(recipeId:Long) = new play.api.mvc.HandlerRef(
   controllers.Application.mealsNewDay(recipeId), HandlerDef(this, "controllers.Application", "mealsNewDay", Seq(classOf[Long]))
)
                              

                      
    
}
                            

// @LINE:60
class ReverseAssets {
    


 
// @LINE:60
def at(path:String, file:String) = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]))
)
                              

                      
    
}
                            
}
                    
                