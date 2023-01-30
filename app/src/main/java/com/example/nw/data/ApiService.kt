package com.example.nw.data

import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("{category}")
    suspend fun getCategory(
        @Path("category") category: String
    ):RetrofitModel
}