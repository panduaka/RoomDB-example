package com.example.cartrackapp.ui.signin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.cartrackapp.R
import com.example.cartrackapp.ui.main.MainActivity
import com.example.cartrackapp.ui.signup.UserRegisterActivity
import kotlinx.android.synthetic.main.user_signin_activity_layout.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserSingInActivity : AppCompatActivity() {

    private val viewModel by viewModel<UserSignInViewModel>()
    private var isUserAvailable: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_signin_activity_layout)

        viewModel.run {
            onUsersDBListLoaded.observe(this@UserSingInActivity, Observer {
                if (it.isNullOrEmpty()) {
                    Toast.makeText(this@UserSingInActivity, "No Users Available", Toast.LENGTH_LONG).show()
                } else {
                    val userName = userSingInNameEditText.text.toString()
                    val password = userSignInPasswordEditText.text.toString()
                    it.forEach { userDB ->
                        if (userName == userDB.firstName && password == userDB.password) isUserAvailable = true

                    }
                    if (isUserAvailable) {
                        val i = Intent(this@UserSingInActivity, MainActivity::class.java)
                        startActivity(i)
                        finish()
                    } else {
                        Toast.makeText(
                            this@UserSingInActivity, "Invalid Username or Password",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            })
        }

        userSingInButton.setOnClickListener {
            viewModel.onGetUsers.postValue(Unit)
        }
        userRegisterNavigateButton.setOnClickListener {
            val i = Intent(this@UserSingInActivity, UserRegisterActivity::class.java)
            startActivity(i)
        }

    }
}