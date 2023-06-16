package com.example.ayopintar.ui.dashboard.profile

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ayopintar.api.ApiConfig
import com.example.ayopintar.api.response.DataProfile
import com.example.ayopintar.api.response.GetProfileResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileViewModel : ViewModel() {

    private val _profileResult = MutableLiveData<DataProfile>()
    val profileResult: LiveData<DataProfile> = _profileResult

    /*private val _isLoading = MutableLiveData<Boolean>()
    val isLoading : LiveData<Boolean> = _isLoading*/

    fun getProfile(token: String, username: String) {
        val api = ApiConfig.getApiService().getprofile("Bearer $token", username)
        api.enqueue(object : Callback<GetProfileResponse> {
            override fun onResponse(call: Call<GetProfileResponse>, response: Response<GetProfileResponse>) {
                if (response.isSuccessful) {
                    _profileResult.value = response.body()!!.data
                }
            }

            override fun onFailure(call: Call<GetProfileResponse>, t: Throwable) {
                Log.e("getProfile", "onFailur ${t.message}")
            }

        })
    }
}