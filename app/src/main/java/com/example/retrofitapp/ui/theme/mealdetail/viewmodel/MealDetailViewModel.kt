package com.example.retrofitapp.ui.theme.mealdetail.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitapp.networking.MealDetail
import com.example.retrofitapp.ui.theme.mealdetail.repository.MealDetailRepository
import kotlinx.coroutines.launch


class MealDetailViewModel(private val repository: MealDetailRepository) : ViewModel() {

    private val _mealDetail = MutableLiveData<MealDetail>()
    val mealDetail: LiveData<MealDetail> = _mealDetail

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    fun getMealDetail(mealId: String) {
        _loading.value = true
        viewModelScope.launch {
            val result = repository.getMealDetail(mealId)
            _loading.value = false
            when (result) {
                // is Result.Success<*> -> _mealDetail.value = result.data as MealDetail?
                // is Result.Failure -> _error.value = "Failed to load meal detail"
            }
        }
    }
}

