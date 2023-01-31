package com.example.nw

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nw.data.RetrofitRepository
import kotlinx.coroutines.launch

class MainFragmentViewModel : ViewModel() {

    private val retrofitRepository = RetrofitRepository()

    fun getPathCategory(key:String,q:String,image_type:String) {
        viewModelScope.launch {
            retrofitRepository.getCategory(key, q, image_type)
            Log.d("MyLog","VM:${retrofitRepository.getCategory(key,q, image_type)}")
        }
    }
}