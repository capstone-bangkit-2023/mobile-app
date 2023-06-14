package com.example.ayopintar.api.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(

    @field:SerializedName("code")
    val code: Int,

    @field:SerializedName("data")
    val data: Data,

    @field:SerializedName("status")
    val status: String
)

data class Data(

    @field:SerializedName("accessToken")
    val accessToken: String
)