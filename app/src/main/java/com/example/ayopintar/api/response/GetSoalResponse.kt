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

data class SoalItem(

	@field:SerializedName("createdAt")
	val createdAt: String,

	@field:SerializedName("soal")
	val soal: String,

	@field:SerializedName("kode_soal")
	val kodeSoal: String,

	@field:SerializedName("kode_matapelajaran")
	val kodeMatapelajaran: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("jawaban")
	val jawaban: String,

	@field:SerializedName("updatedAt")
	val updatedAt: String
)

data class DataSoal(

	@field:SerializedName("soal")
	val soal: List<SoalItem>
)
