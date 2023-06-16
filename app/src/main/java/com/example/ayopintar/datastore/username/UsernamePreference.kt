package com.example.ayopintar.datastore.username

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UsernamePreference private constructor(private val dataStore: DataStore<Preferences>) {

    private val USERNAME = stringPreferencesKey("username")

    fun getUsername(): Flow<String> {
        return dataStore.data.map {
            it[USERNAME] ?: ""
        }
    }

    suspend fun saveUsername(username: String) {
        dataStore.edit {
            it[USERNAME] = username
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: UsernamePreference? = null

        fun getInstance(dataStore: DataStore<Preferences>): UsernamePreference {
            return INSTANCE ?: synchronized(this) {
                val instance = UsernamePreference(dataStore)
                INSTANCE = instance
                instance
            }
        }
    }
}