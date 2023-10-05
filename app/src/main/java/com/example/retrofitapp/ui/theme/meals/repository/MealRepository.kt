package com.example.retrofitapp.ui.theme.meals.repository

import com.example.retrofitapp.networking.Meal
import com.example.retrofitapp.networking.RetrofitInstance

class MealRepository {
    private val api = RetrofitInstance.api

    suspend fun getMealsByCategory(category: String): Result<List<Meal>> {
        return try {
            val response = api.getMealsByCategory(category)
            Result.success(response.meals)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}

