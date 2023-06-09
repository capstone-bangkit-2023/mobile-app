package com.example.ayopintar.api.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PelajaranResponse(
    val mataPelajaran: String,
    val pendidikan: String,
    val photo: String
):Parcelable
