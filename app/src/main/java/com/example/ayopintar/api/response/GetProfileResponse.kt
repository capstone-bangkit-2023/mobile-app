package com.example.ayopintar.api.response

import com.google.gson.annotations.SerializedName

data class GetProfileResponse(

	@field:SerializedName("code")
	val code: Int,

	@field:SerializedName("data")
	val data: DataProfile,

	@field:SerializedName("status")
	val status: String
)

data class DataProfile(

	@field:SerializedName("createdAt")
	val createdAt: String,

	@field:SerializedName("namaSekolah")
	val namaSekolah: String,

	@field:SerializedName("resetPasswordLink")
	val resetPasswordLink: String,

	@field:SerializedName("nama")
	val nama: String,

	@field:SerializedName("foto")
	val foto: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("email")
	val email: String,

	@field:SerializedName("username")
	val username: String,

	@field:SerializedName("updatedAt")
	val updatedAt: String
)
