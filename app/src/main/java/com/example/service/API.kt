package com.example.service

import com.google.android.gms.wearable.DataItem
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface API {
    @GET("users")
    fun getUsers(): Call<List<PostResponse>>

    @FormUrlEncoded
    @POST("mahasiswa/")
    fun addMahasiswa(@Body req : DataItem): Call<CreatePostResponse>
}