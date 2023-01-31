package com.example.nw.data

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("api/")
    suspend fun getCategory(
        @Query("key") key:String,
        @Query("q") q:String,
        @Query("image_type") image_type:String
    ):RetrofitModel
}