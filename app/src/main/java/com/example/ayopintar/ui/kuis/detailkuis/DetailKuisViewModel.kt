package com.example.ayopintar.ui.kuis.detailkuis

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ayopintar.api.ApiConfig
import com.example.ayopintar.api.response.GetSoalResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailKuisViewModel : ViewModel() {

    private val _getSoalResult = MutableLiveData<String>()
    val getSoalResult: LiveData<String> = _getSoalResult

    fun getSoal(token: String, id: String) {
        val api = ApiConfig.getApiService().getSoal("Bearer $token", id)
        api.enqueue(object : Callback<GetSoalResponse> {
            override fun onResponse(call: Call<GetSoalResponse>, response: Response<GetSoalResponse>) {
                if (response.isSuccessful) {
                    if (response.body() != null) {
                        _getSoalResult.value = response.body()!!.data.soal.soal
                    }
                }
            }

            override fun onFailure(call: Call<GetSoalResponse>, t: Throwable) {
                Log.e("getSoal", "onFailure : ${t.message}")
            }
        })
    }
}