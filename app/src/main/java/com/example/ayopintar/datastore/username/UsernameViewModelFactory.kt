package com.example.ayopintar.datastore.username

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class UsernameViewModelFactory(private val pref: UsernamePreference) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UsernameViewModel(pref) as T
    }
}