package com.example.retrofitapp.ui.theme.meals.viewmodel

// MealsViewModel.kt


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitapp.networking.Meal
import com.example.retrofitapp.ui.theme.meals.repository.MealRepository
import kotlinx.coroutines.launch

class MealsViewModel(private val repository: MealRepository) : ViewModel() {

    private val _meals = MutableLiveData<List<Meal>>()
    val meals: LiveData<List<Meal>> = _meals

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    fun getMealsByCategory(category: String) {
        _loading.value = true
        viewModelScope.launch {
            val result = repository.getMealsByCategory(category)
            _loading.value = false
            when (result) {
                is Result.Success<*> -> _meals.value = result.data as List<Meal>?
                //is Result.Failure -> _error.value = "Failed to load meals"
            }
        }
    }
}
