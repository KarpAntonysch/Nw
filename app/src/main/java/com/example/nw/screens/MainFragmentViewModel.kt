package com.example.nw.screens

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nw.R
import com.example.nw.data.RetrofitModel
import com.example.nw.data.RetrofitRepository
import kotlinx.coroutines.launch

class MainFragmentViewModel : ViewModel() {

    private val retrofitRepository = RetrofitRepository()

    fun internetChecking(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectivityManager.activeNetwork ?: return false
        val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false
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

    fun getPathCategory(context: Context, q: String): LiveData<RetrofitModel> {
        val hitList = MutableLiveData<RetrofitModel>()
        viewModelScope.launch {
            try {
                hitList.postValue(retrofitRepository.getCategory(q, "photo"))
            } catch (e: com.google.gson.stream.MalformedJsonException) {
                Toast.makeText(context, R.string.vpn, Toast.LENGTH_SHORT).show()
            } catch (e: retrofit2.HttpException) {
                if (e.code() == 400) {
                    Toast.makeText(context, R.string.http400, Toast.LENGTH_SHORT).show()
                }
                if (e.code() == 404) {
                    Toast.makeText(context, R.string.http400, Toast.LENGTH_SHORT).show()
                }
            } catch (e: javax.net.ssl.SSLException) {
                Toast.makeText(context, R.string.ssl, Toast.LENGTH_SHORT).show()
            }
        }
        return hitList
    }
}