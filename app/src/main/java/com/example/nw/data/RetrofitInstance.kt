package com.example.nw.data

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstance {

    val api_interceptor = Interceptor {
        val originalRequest = it.request()
        val newHttpUrl = originalRequest.url.newBuilder()
            .addQueryParameter("app_key", "?key=33106230-b104905cd7ff74ed17e2229af")
            .build()
        val newRequest = originalRequest.newBuilder()
            .url(newHttpUrl)
            .build()
        it.proceed(newRequest)
    }

    val clientHTTP = OkHttpClient().newBuilder()
        .addNetworkInterceptor(api_interceptor)
        .build()

    private val retrofit by lazy {
        Retrofit.Builder()
            //.client(clientHTTP)
            .baseUrl("https://pixabay.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: ApiService by lazy{
        retrofit.create(ApiService::class.java)
    }
}