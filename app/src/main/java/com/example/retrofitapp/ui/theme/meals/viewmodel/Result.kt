package com.example.retrofitapp.ui.theme.meals.viewmodel

sealed class Result<out T> {
    data class Success<out T>(val data: T) : Result<T>()
    class Failure(val exception: Exception) : Result<Nothing>()
}

