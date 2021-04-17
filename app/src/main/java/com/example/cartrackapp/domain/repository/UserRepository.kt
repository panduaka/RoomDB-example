package com.example.cartrackapp.domain.repository

import com.example.cartrackapp.clean_architecture.Response
import com.example.cartrackapp.domain.model.UserDomain


interface UserRepository {
    suspend fun getUser(): Response<List<UserDomain>?>
}