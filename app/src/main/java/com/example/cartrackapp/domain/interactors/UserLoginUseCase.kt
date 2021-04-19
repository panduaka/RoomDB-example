package com.example.cartrackapp.domain.interactors

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cartrackapp.clean_architecture.Response
import com.example.cartrackapp.domain.repository.LoginRepository
import com.example.cartrackapp.room_database.UserDB
import com.example.movieapp.cleanarch.UseCase
import com.example.cartrackapp.clean_architecture.*
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch


class UserLoginUseCase(private val userLoginRepository: LoginRepository, private val application: Application) :
    UseCase<LiveData<Result<List<UserDB>>>>, UseCaseScope {

    override fun execute(): LiveData<Result<List<UserDB>>> {
        val result = MutableLiveData<Result<List<UserDB>>>()
        result.postValue(Result.Loading)
        launch {
            val toPost = when (val response = userLoginRepository.getUsers(application)) {
                is Response.Success -> Result.Success(response.data)
                is Response.Error -> Result.Error(response.exception)
            }
            result.postValue(toPost)
        }
        return result
    }

    override fun cancel() {
        coroutineContext.cancel()
    }

}