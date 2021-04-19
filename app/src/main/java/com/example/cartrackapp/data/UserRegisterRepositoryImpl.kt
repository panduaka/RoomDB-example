package com.example.cartrackapp.data

import android.app.Application
import com.example.cartrackapp.clean_architecture.Response
import com.example.cartrackapp.domain.repository.UserRegisterRepository
import com.example.cartrackapp.room_database.AppDatabase
import com.example.cartrackapp.room_database.UserDB
import java.lang.Exception

class UserRegisterRepositoryImpl : UserRegisterRepository {
    override suspend fun registerUser(user: UserDB, application: Application): Response<Unit> {
        val database = AppDatabase.getDatabase(application)
        val dao = database.userDao()
        return try {
            dao.insertUser(user)
            Response.Success(Unit)
        } catch (e: Exception) {
            Response.Error(e)
        }
    }
}