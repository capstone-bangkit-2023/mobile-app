package com.example.ayopintar.datastore.token

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class TokenViewModelFactory(private val pref: TokenPreference) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TokenViewModel(pref) as T
    }
}