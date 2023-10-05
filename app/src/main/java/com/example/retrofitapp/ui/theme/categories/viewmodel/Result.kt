package com.example.retrofitapp.ui.theme.categories.viewmodel

sealed class Result<out T> {
    data class Success<out T>(val data: T) : Result<T>()
    class Failure(val exception: Exception) : Result<Nothing>()
}

