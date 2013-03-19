package models

case class RecipeFilter(name: String, tag: String, rating: Int, ingredient: String, sorting: Int, onlyMyRecipes: Boolean, userId: Long)
