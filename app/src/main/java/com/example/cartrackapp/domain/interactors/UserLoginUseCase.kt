package com.example.cartrackapp.domain.interactors

import android.app.Application
import com.example.cartrackapp.domain.repository.LoginRepository

class UserLoginUseCase(private val userLoginRepository: LoginRepository, private val application: Application) {
}