package com.example.cartrackapp.domain.repository

import android.app.Application
import com.example.cartrackapp.clean_architecture.Response
import com.example.cartrackapp.room_database.UserDB

interface LoginRepository {
    suspend fun getUsers(application: Application): Response<List<UserDB>>
}