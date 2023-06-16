package com.example.ayopintar.ui.kuis.nilaikuis

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ayopintar.api.ApiConfig
import com.example.ayopintar.api.response.PostJawabanResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NilaiKuisViewModel : ViewModel() {

    private val _nilaiResult = MutableLiveData<String>()
    val nilaiResult: LiveData<String> = _nilaiResult

    fun postJawaban(token: String, kodeSoal: String, jawaban: String) {
        val api = ApiConfig.getApiService().postSoal(" Bearer $token", kodeSoal, jawaban)
        api.enqueue(object : Callback<PostJawabanResponse> {
            override fun onResponse(call: Call<PostJawabanResponse>, response: Response<PostJawabanResponse>) {
                if (response.isSuccessful) {
                    if (response.body() != null) {
                        _nilaiResult.value = response.body()!!.data.toString()
                    }
                }
            }

            override fun onFailure(call: Call<PostJawabanResponse>, t: Throwable) {
                Log.e("postSoal", "onFailure : ${t.message}")
            }
        })
    }
}