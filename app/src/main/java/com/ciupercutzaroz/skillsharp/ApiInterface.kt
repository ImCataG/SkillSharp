package com.ciupercutzaroz.skillsharp
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
interface ApiInterface {
    @GET("getjson")
    fun getData(): Call<String>

    @POST("custom")
    fun postData(@Body data: String): Call<String>
}