package com.example.ayopintar.ui.kuis

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ayopintar.R

class KuisActivity : AppCompatActivity() {
    companion object {
        const val extraMapel = "EXTRA_MAPEL"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kuis)

        supportActionBar?.hide()
    }
}