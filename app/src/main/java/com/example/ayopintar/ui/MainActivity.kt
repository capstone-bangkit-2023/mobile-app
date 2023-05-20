package com.example.ayopintar.ui


import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.example.ayopintar.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}