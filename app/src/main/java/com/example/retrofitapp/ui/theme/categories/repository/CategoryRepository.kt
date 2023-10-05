package com.example.retrofitapp.ui.theme.categories.repository

import com.example.retrofitapp.networking.Category
import com.example.retrofitapp.networking.RetrofitInstance


class CategoryRepository {
    private val api = RetrofitInstance.api

    suspend fun getCategories(): Result<List<Category>> {
        return try {
            val response = api.getCategories()
            Result.success(response.categories)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
