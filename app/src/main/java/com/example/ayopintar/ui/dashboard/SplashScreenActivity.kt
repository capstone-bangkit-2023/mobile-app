package com.example.ayopintar.ui.dashboard

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import com.example.ayopintar.R
import com.example.ayopintar.datastore.token.TokenPreference
import com.example.ayopintar.datastore.token.TokenViewModel
import com.example.ayopintar.datastore.token.TokenViewModelFactory
import com.example.ayopintar.ui.auth.AuthActivity

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "token")

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {
    companion object{
        const val delay = 2000L
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val pref = TokenPreference.getInstance(dataStore)
        val tokenViewModel = ViewModelProvider(this, TokenViewModelFactory(pref))[TokenViewModel::class.java]

        Handler(Looper.getMainLooper()).postDelayed(
            {
                tokenViewModel.getToken().observe(this) {
                    if (it != "") {
                       startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    } else {
                        startActivity(Intent(this, AuthActivity::class.java))
                        finish()
                    }
                }
            }, delay
        )
    }
}