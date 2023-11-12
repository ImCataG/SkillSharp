package com.ciupercutzaroz.skillsharp
import retrofit2.Call
import retrofit2.http.GET
interface ApiInterface {
    @GET("api/v1/categories")
    fun getData(): Call<String>

}