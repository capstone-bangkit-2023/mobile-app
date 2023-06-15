package com.example.ayopintar.api.response

import com.google.gson.annotations.SerializedName

data class GetSoalResponse(

	@field:SerializedName("code")
	val code: Int,

	@field:SerializedName("data")
	val data: DataSoal,

	@field:SerializedName("status")
	val status: String
)

data class Soal(

	@field:SerializedName("soal")
	val soal: String,

	@field:SerializedName("kode_soal")
	val kodeSoal: String
)

data class DataSoal(

	@field:SerializedName("soal")
	val soal: Soal
)
