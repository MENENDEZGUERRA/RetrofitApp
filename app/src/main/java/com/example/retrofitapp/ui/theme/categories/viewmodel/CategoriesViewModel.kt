package com.example.retrofitapp.ui.theme.categories.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitapp.networking.Category
import com.example.retrofitapp.ui.theme.categories.repository.CategoryRepository
import kotlinx.coroutines.launch

class CategoriesViewModel(private val repository: CategoryRepository) : ViewModel() {

    private val _categories = MutableLiveData<List<Category>>()
    val categories: LiveData<List<Category>> = _categories

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    fun getCategories() {
        _loading.value = true
        viewModelScope.launch {
            val result = repository.getCategories()
            _loading.value = false
            when (result) {
                is Result.Success<*> -> _categories.value = result.data as List<Category>?
                // is Result.Failure -> _error.value = "Failed to load categories"
            }
        }
    }
}
