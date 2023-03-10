package com.example.nw.data

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val KEY = "33106230-b104905cd7ff74ed17e2229af"

    private val clientHTTP = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val url = chain
                .request()
                .url
                .newBuilder()
                .addQueryParameter("key", KEY)
                .build()
            chain.proceed(chain.request().newBuilder().url(url).build())
        }
        .build()

    private val retrofit by lazy {
        Retrofit.Builder()
            .client(clientHTTP)
            .baseUrl("https://pixabay.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: ApiService by lazy{
        retrofit.create(ApiService::class.java)
    }
}