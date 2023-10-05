package com.example.retrofitapp.ui.theme.mealdetail.repository

import com.example.retrofitapp.networking.MealDetail
import com.example.retrofitapp.networking.RetrofitInstance


class MealDetailRepository {
    private val api = RetrofitInstance.api

    suspend fun getMealDetail(mealId: String): Result<MealDetail> {
        return try {
            val response = api.getMealDetail(mealId)
            // Asumiendo que la API siempre devuelve al menos un detalle de comida
            // y que estamos interesados en el primer elemento.
            val mealDetail = response.meals.firstOrNull()
            if (mealDetail != null) {
                Result.success(mealDetail)
            } else {
                Result.failure(Exception("Meal detail not found"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
