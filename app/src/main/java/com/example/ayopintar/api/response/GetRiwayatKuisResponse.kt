package com.example.ayopintar.api.response

import com.google.gson.annotations.SerializedName

data class GetRiwayatKuisResponse(

	@field:SerializedName("code")
	val code: Int,

	@field:SerializedName("data")
	val data: DataRiwayatKuis,

	@field:SerializedName("status")
	val status: String
)
// Agak laen
data class DataRiwayatKuis(

	@field:SerializedName("nilaiTerbaruPerMapel")
	val nilaiTerbaruPerMapel: NilaiTerbaruPerMapel
)

data class NilaiTerbaruPerMapel(

	@field:SerializedName("geo")
	val geo: List<Int>,

	@field:SerializedName("mat")
	val mat: List<Int>,

	@field:SerializedName("fis")
	val fis: List<Int>,

	@field:SerializedName("pkn")
	val pkn: List<Int>,

	@field:SerializedName("bindo")
	val bindo: List<Int>,

	@field:SerializedName("eko")
	val eko: List<Int>,

	@field:SerializedName("Fisika")
	val fisika: List<Int>
)
