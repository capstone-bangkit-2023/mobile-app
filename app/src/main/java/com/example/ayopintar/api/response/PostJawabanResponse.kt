package com.example.ayopintar.api.response

import com.google.gson.annotations.SerializedName

data class PostJawabanResponse(

	@field:SerializedName("code")
	val code: Int,

	@field:SerializedName("data")
	val data: Int,

	@field:SerializedName("status")
	val status: String
)
