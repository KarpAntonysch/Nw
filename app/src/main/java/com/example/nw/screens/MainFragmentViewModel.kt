package com.example.nw.screens

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log
import android.util.MalformedJsonException
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nw.data.Hit
import com.example.nw.data.RetrofitModel
import com.example.nw.data.RetrofitRepository
import kotlinx.coroutines.launch
import org.json.JSONException

class MainFragmentViewModel : ViewModel() {

    private val retrofitRepository = RetrofitRepository()

    fun internetChecking(context: Context) : Boolean{
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectivityManager.activeNetwork?:return false
        val activeNetwork = connectivityManager.getNetworkCapabilities(network)?: return false
        return when {
            // wi-fi
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            // сотовый интернет
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            else -> {
                false
            }
        }
    }
    fun getPathCategory(q:String):LiveData<RetrofitModel> {
        val hitList = MutableLiveData<RetrofitModel>()
        try {
            viewModelScope.launch {
                hitList.postValue(retrofitRepository.getCategory( q, "photo"))
            }
        }catch (e : Exception){

        }

        return hitList
    }
}