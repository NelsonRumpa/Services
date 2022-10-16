package com.example.service

import com.google.gson.annotations.SerializedName

class CreatePostResponse {
    val userId = String
    val id = Int
    val title = String
    @SerializedName("body")
    val text = String
}