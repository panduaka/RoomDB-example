package com.example.cartrackapp.ui.signin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cartrackapp.R
import com.example.cartrackapp.ui.signup.UserRegisterActivity
import kotlinx.android.synthetic.main.user_signin_activity_layout.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserSingInActivity: AppCompatActivity() {

    private val viewModel by viewModel<UserSignInViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_signin_activity_layout)

        userRegisterNavigateButton.setOnClickListener {
            val i = Intent(this@UserSingInActivity, UserRegisterActivity::class.java)
            startActivity(i)
        }

    }
}