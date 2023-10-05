package com.example.retrofitapp.networking

import com.google.gson.annotations.SerializedName

// MealDataClasses.kt

/**
 * [MealsResponse] represents the API response containing a list of [Meal].
 */
data class MealsResponse(
    @SerializedName("meals") val meals: List<Meal>
)

/**
 * [Meal] represents a summary of a meal item with its name, image URL, and ID.
 */
data class Meal(
    @SerializedName("strMeal") val name: String,
    @SerializedName("strMealThumb") val imageUrl: String,
    @SerializedName("idMeal") val id: String
)

/**
 * [MealDetailResponse] represents the API response containing a list of [MealDetail].
 */
data class MealDetailResponse(
    @SerializedName("meals") val meals: List<MealDetail>
)

/**
 * [MealDetail] represents detailed information about a specific meal.
 */
data class MealDetail(
    @SerializedName("idMeal") val id: String,
    @SerializedName("strMeal") val name: String,
    @SerializedName("strMealThumb") val imageUrl: String,
    @SerializedName("strInstructions") val instructions: String
    // agregar otros campos luego
)
