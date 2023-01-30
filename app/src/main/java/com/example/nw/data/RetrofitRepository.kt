package com.example.nw.data

class RetrofitRepository {
    suspend fun getCategory(category:String):RetrofitModel{
        return RetrofitInstance.api.getCategory(category)
    }
}