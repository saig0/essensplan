package models

case class MealProposals(proposals: List[MealProposal])

case class MealProposal(recipeId: Long, checked: Boolean = false)
