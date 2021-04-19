package com.example.cartrackapp.ui.signup

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cartrackapp.R
import com.example.cartrackapp.room_database.UserDB
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserRegisterActivity: AppCompatActivity() {

    private val viewModel by viewModel<UserRegisterViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_register_activity_layout)


        viewModel.insertUser(
            UserDB(
                    0,
                "Panduka","Wedisinghe", "Sri Lanka"
            )
        )
    }
}