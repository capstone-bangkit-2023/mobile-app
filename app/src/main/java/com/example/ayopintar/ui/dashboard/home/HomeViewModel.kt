package com.example.ayopintar.ui.dashboard.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ayopintar.api.ApiConfig
import com.example.ayopintar.api.response.DataItem
import com.example.ayopintar.api.response.GetListMapelResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {


    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _loginResult = MutableLiveData<List<DataItem?>?>()
    val loginResult: LiveData<List<DataItem?>?> = _loginResult
    fun getListMapel(token: String) {
        val api = ApiConfig.getApiService().getListMapel("Bearer $token")
        _isLoading.value = true
        api.enqueue(object : Callback<GetListMapelResponse> {
            override fun onResponse(call: Call<GetListMapelResponse>, response: Response<GetListMapelResponse>) {
                if (response.isSuccessful) {
                    if (response.body() != null) {
                        _loginResult.value = response.body()!!.data
                        _isLoading.value = false
                    }
                }
            }

            override fun onFailure(call: Call<GetListMapelResponse>, t: Throwable) {
                _isLoading.value = false
                Log.e("getListMapel", "onFailure : ${t.message}")
            }
        })
    }
}