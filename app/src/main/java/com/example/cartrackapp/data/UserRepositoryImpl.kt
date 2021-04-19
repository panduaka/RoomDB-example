package com.example.cartrackapp.data

import com.example.cartrackapp.clean_architecture.Response
import com.example.cartrackapp.data.mapper.getUsers
import com.example.cartrackapp.data.model.DataUser
import com.example.cartrackapp.data.service.CarTrackService
import com.example.cartrackapp.domain.model.AddressDomain
import com.example.cartrackapp.domain.model.CompanyDomain
import com.example.cartrackapp.domain.model.GeoDomain
import com.example.cartrackapp.domain.model.UserDomain
import com.example.cartrackapp.domain.repository.UserRepository

class UserRepositoryImpl(private val carTrackService: CarTrackService) : UserRepository {
    class ResponseException(message: String) : Exception(message)

    override suspend fun getUser(): Response<List<UserDomain>?> {
        return try {
            val users = carTrackService.getUsers()
            if (users.isSuccessful) {
                Response.Success(getUsers(users = users.body()))
            } else {
                Response.Error(ResponseException(users.message()))
            }
        } catch (e: java.lang.Exception) {
            Response.Error(e)
        }
    }
}