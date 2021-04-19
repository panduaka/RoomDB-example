package com.example.cartrackapp.domain.interactors

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cartrackapp.clean_architecture.Result
import com.example.cartrackapp.clean_architecture.Response
import com.example.cartrackapp.domain.repository.UserRegisterRepository
import com.example.cartrackapp.room_database.UserDB
import com.example.movieapp.cleanarch.UseCaseWithParameter
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class RegisterUserUseCase(private val userRegisterRepository: UserRegisterRepository, private val application: Application) :
    UseCaseWithParameter<UserDB, LiveData<Result<Boolean>>>, UseCaseScope {

    override fun execute(parameter: UserDB): LiveData<Result<Boolean>> {

        val result = MutableLiveData<Result<Boolean>>()
        result.postValue(Result.Loading)
        launch {
            val toPost = when (val response = userRegisterRepository.registerUser(parameter, application)) {
                is Response.Success -> Result.Success(true)
                is Response.Error -> Result.Success(false)
            }
            result.postValue(toPost)
        }
        return result
    }

    override fun cancel() {
        coroutineContext.cancel()
    }
}