package zebaszp.ejercicio4hs.domain

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Meal(
    @SerialName("strMeal") val name: String)

@Serializable
data class MealSearchResult(val meals: List<Meal>)