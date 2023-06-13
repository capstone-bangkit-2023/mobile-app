package com.example.ayopintar.api.response

import com.google.gson.annotations.SerializedName

data class RegisterResponse(

    @field:SerializedName("code")
    val code: Int,

    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("status")
    val status: String
)