package com.example.service

import com.google.gson.annotations.SerializedName

class PostResponse {
    val id = Int
    val nama = String
    val nim = String
    val alamat = String
    val email = String
    val foto = String
    val title = String
    @SerializedName("body")
    val text = String
}