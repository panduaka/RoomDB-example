package com.example.cartrackapp.data

import android.app.Application
import com.example.cartrackapp.clean_architecture.Response
import com.example.cartrackapp.domain.repository.LoginRepository
import com.example.cartrackapp.room_database.UserDB

class UserLoginRepositoryImpl : LoginRepository {
    override suspend fun getUsers(application: Application): Response<List<UserDB>> {
        TODO("Not yet implemented")
    }
}