package com.example.cartrackapp.data

import android.app.Application
import com.example.cartrackapp.clean_architecture.Response
import com.example.cartrackapp.domain.repository.LoginRepository
import com.example.cartrackapp.room_database.AppDatabase
import com.example.cartrackapp.room_database.UserDB
import java.lang.Exception

class UserLoginRepositoryImpl : LoginRepository {
    override suspend fun getUsers(application: Application): Response<List<UserDB>> {
        val database = AppDatabase.getDatabase(application)
        val dao = database.userDao()
        return try {
            val userList = dao.getAll()
            Response.Success(userList)
        } catch (e: Exception) {
            Response.Error(e)
        }
    }
}