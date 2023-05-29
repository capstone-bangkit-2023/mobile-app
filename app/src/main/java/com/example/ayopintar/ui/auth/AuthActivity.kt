package com.example.ayopintar.ui.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ayopintar.databinding.ActivityAuthBinding


class AuthActivity : AppCompatActivity() {
    private lateinit var binding :ActivityAuthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        setContentView(binding.root)
    }
}