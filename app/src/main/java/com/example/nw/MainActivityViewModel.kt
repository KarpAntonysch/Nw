package com.example.nw

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {
    var isLoading = MutableLiveData<Boolean>(true)

    fun splashDelay() {
        viewModelScope.launch {
            // можно управлять задержкой или прописывать фоновые процессы, сплэш скрин будет виден до выполнения всех процессов
            delay(1000L)
            isLoading.value = false
        }
    }
}