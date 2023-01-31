package com.example.nw.data

class RetrofitRepository {
    suspend fun getCategory(q:String,image_type:String):RetrofitModel{
        return RetrofitInstance.api.getCategory(q, image_type)
    }
}