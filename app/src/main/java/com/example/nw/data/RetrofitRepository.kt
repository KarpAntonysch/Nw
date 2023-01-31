package com.example.nw.data

class RetrofitRepository {
    suspend fun getCategory(key:String,q:String,image_type:String):RetrofitModel{
        return RetrofitInstance.api.getCategory(key,q, image_type)
    }
}