package com.example.ayopintar.api.response



data class DataItemNilai(
	val linkFoto: String,
	val pendidikan: String,
	val mataPelajaran: String,
	val nilai: Int = 0,
)

