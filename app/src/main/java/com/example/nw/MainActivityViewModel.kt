package com.example.nw

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivityViewModel:ViewModel() {
     var isLoading = MutableLiveData<Boolean>(true)

    fun d(){
        viewModelScope.launch {
            delay(5000L)
            isLoading.value = false
        }
    }
}