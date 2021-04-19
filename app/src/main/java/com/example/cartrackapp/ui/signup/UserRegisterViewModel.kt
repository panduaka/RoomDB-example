package com.example.cartrackapp.ui.signup

import androidx.lifecycle.ViewModel
import com.example.cartrackapp.domain.interactors.RegisterUserUseCase
import com.example.cartrackapp.room_database.UserDB

class UserRegisterViewModel(private val userUseCase: RegisterUserUseCase): ViewModel() {

    fun insertUser(userDB: UserDB) {
        userUseCase.execute(userDB)
    }
}