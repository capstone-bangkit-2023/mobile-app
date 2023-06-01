package com.example.ayopintar.ui.dashboard

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.ayopintar.R
import com.example.ayopintar.ui.auth.AuthActivity

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

        Handler(Looper.getMainLooper()).postDelayed(
            {
                val intent = Intent(this@SplashScreenActivity, AuthActivity::class.java)
                startActivity(intent)
                finish()
            }, delay
        )

    }
}