package zebaszp.ejercicio4hs.domain

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Meal(
    @SerialName("idMeal") val id: String,
    @SerialName("strMeal") val name: String,
    @SerialName("strCategory") val category: String,
    @SerialName("strMealThumb") val thumbUri: String)

@Serializable
data class MealSearchResult(val meals: List<Meal>)