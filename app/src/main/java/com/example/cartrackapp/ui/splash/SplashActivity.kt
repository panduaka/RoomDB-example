package com.example.cartrackapp.ui.splash

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cartrackapp.R
import com.example.cartrackapp.ui.signin.UserSingInActivity


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity_layout)
        val background: Thread = object : Thread() {
            override fun run() {
                try {
                    sleep((3000).toLong())
                    val i = Intent(this@SplashActivity, UserSingInActivity::class.java)
                    startActivity(i)
                    finish()
                } catch (e: Exception) {
                    Toast.makeText(this@SplashActivity, "Splash Error", Toast.LENGTH_SHORT).show()
                }
            }
        }
        background.start()
    }
}