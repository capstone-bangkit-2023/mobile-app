package com.example.ayopintar.api.response

import com.google.gson.annotations.SerializedName

data class GetListMapelResponse(

	@field:SerializedName("code")
	val code: Int,

	@field:SerializedName("data")
	val data: List<DataItem?>? = null,

	@field:SerializedName("status")
	val status: String
)

data class DataItem(

	@field:SerializedName("link_foto")
	val linkFoto: String? = null,

	@field:SerializedName("createdAt")
	val createdAt: String? = null,

	@field:SerializedName("kode_matapelajaran")
	val kodeMatapelajaran: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("mata_pelajaran")
	val mataPelajaran: String? = null,

	@field:SerializedName("updatedAt")
	val updatedAt: String? = null
)
