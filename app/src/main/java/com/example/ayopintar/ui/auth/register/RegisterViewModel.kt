package com.example.ayopintar.ui.auth.register

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ayopintar.api.ApiConfig
import com.example.ayopintar.api.response.RegisterResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterViewModel : ViewModel() {
    private val _registerMsg = MutableLiveData<String>()
    val registerMsg: LiveData<String> = _registerMsg

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading : LiveData<Boolean> = _isLoading

    fun postRegister(username: String, password: String, confirmPassword: String, nama: String, namaSekolah: String?, email: String) {
        _isLoading.value = true
        val api = ApiConfig.getApiService().registerApi(username, password, confirmPassword, nama, namaSekolah, email)
        api.enqueue(object : Callback<RegisterResponse> {
            override fun onResponse(call: Call<RegisterResponse>, response: Response<RegisterResponse>) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    if (response.body() != null) {
                        _registerMsg.value = response.body()!!.message
                    }
                }
            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                _isLoading.value = false
                Log.e("postRegister", "onFailure : ${t.message}")
                _registerMsg.value = t.message
            }
        })
    }
}