package com.example.ayopintar.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.ayopintar.databinding.ActivityAuthBinding


class AuthActivity : AppCompatActivity() {
    private lateinit var binding :ActivityAuthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)

        installSplashScreen()
        supportActionBar?.hide()
        setContentView(binding.root)
    }
}