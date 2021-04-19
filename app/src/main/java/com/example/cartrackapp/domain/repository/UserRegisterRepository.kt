package com.example.cartrackapp.domain.repository

import android.app.Application
import com.example.cartrackapp.clean_architecture.Response
import com.example.cartrackapp.room_database.UserDB

interface UserRegisterRepository {
    suspend fun registerUser(user: UserDB, application: Application): Response<Unit>
}