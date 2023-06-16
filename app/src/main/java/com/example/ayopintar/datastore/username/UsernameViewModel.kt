package com.example.ayopintar.datastore.username

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UsernameViewModel(private val pref: UsernamePreference) : ViewModel() {

    fun getUsername() : LiveData<String> {
        return pref.getUsername().asLiveData()
    }

    fun saveUsername(username: String) {
        viewModelScope.launch {
            pref.saveUsername(username)
        }
    }
}