package com.example.ayopintar.ui.kuis.detailkuis

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ayopintar.api.ApiConfig
import com.example.ayopintar.api.response.GetSoalResponse
import com.example.ayopintar.api.response.Soal
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailKuisViewModel : ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoding: LiveData<Boolean> = _isLoading


    private val _getSoalResult = MutableLiveData<Soal>()
    val getSoalResult: LiveData<Soal> = _getSoalResult

    fun getSoal(token: String, id: String) {
        val api = ApiConfig.getApiService().getSoal("Bearer $token", id)
        _isLoading.value = true
        api.enqueue(object : Callback<GetSoalResponse> {
            override fun onResponse(call: Call<GetSoalResponse>, response: Response<GetSoalResponse>) {

                if (response.isSuccessful) {
                    if (response.body() != null) {
                        _isLoading.value = false
                        _getSoalResult.value = response.body()!!.data.soal
                    }
                }
            }

            override fun onFailure(call: Call<GetSoalResponse>, t: Throwable) {
                Log.e("getSoal", "onFailure : ${t.message}")
                _isLoading.value = false
            }
        })
    }
}