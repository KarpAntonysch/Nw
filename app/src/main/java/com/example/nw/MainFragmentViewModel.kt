package com.example.nw

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nw.data.Hit
import com.example.nw.data.RetrofitModel
import com.example.nw.data.RetrofitRepository
import kotlinx.coroutines.launch

class MainFragmentViewModel : ViewModel() {

    private val retrofitRepository = RetrofitRepository()


    fun getPathCategory(q:String):LiveData<RetrofitModel> {
        val hitList = MutableLiveData<RetrofitModel>()
        viewModelScope.launch {
             hitList.postValue(retrofitRepository.getCategory( q, "photo"))
        }
        return hitList
    }
}