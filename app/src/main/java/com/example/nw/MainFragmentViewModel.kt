package com.example.nw

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nw.data.RetrofitRepository
import kotlinx.coroutines.launch

class MainFragmentViewModel : ViewModel() {

    private val retrofitRepository = RetrofitRepository()

    fun getPathCategory(category: String) {
        viewModelScope.launch {
            retrofitRepository.getCategory(category)
        }
    }
}