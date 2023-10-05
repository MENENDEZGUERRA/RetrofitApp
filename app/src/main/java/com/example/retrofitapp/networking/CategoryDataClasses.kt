package com.example.retrofitapp.networking

import com.google.gson.annotations.SerializedName

// CategoryDataClasses.kt

/**
 * [CategoriesResponse] represents the API response containing a list of [Category].
 */
data class CategoriesResponse(
    @SerializedName("categories") val categories: List<Category>
)

/**
 * [Category] represents a meal category with its ID, name, image URL, and description.
 */
data class Category(
    @SerializedName("idCategory") val id: String,
    @SerializedName("strCategory") val name: String,
    @SerializedName("strCategoryThumb") val imageUrl: String,
    @SerializedName("strCategoryDescription") val description: String
)
