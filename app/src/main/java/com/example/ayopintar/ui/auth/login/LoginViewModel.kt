package com.example.ayopintar.ui.auth.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ayopintar.api.ApiConfig
import com.example.ayopintar.api.response.Data
import com.example.ayopintar.api.response.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel : ViewModel() {

    private val _loginMsg = MutableLiveData<String>()
    val loginMsg: LiveData<String> = _loginMsg

    private val _loginResult = MutableLiveData<Data>()
    val loginResult: LiveData<Data> = _loginResult

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading : LiveData<Boolean> = _isLoading

    fun postLogin(username: String, password: String) {
        _isLoading.value = true
        val api = ApiConfig.getApiService().loginApi(username, password)
        api.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    if (response.code() != 404) {
                        _loginMsg.value = response.body()!!.status
                        _loginResult.value = response.body()!!.data
                        Log.e("Login","Error: ${response.body()!!.status}")
                    }else{
                        _loginMsg.value = response.body()!!.status
                    }
                }
            }


            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                _isLoading.value = false
                Log.e("postLogin", "onFailure : ${t.message}")
                _loginMsg.value = t.message
            }
        })
    }
}