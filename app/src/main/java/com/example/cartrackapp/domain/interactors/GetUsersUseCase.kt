package com.example.cartrackapp.domain.interactors

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cartrackapp.clean_architecture.Response
import com.example.cartrackapp.domain.model.UserDomain
import com.example.cartrackapp.domain.repository.UserRepository
import com.example.cartrackapp.clean_architecture.Result
import com.example.movieapp.cleanarch.UseCase
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class GetUsersUseCase(private val userRepository: UserRepository) : UseCase<LiveData<Result<List<UserDomain>?>>>,
    UseCaseScope {
    override fun execute(): LiveData<Result<List<UserDomain>?>> {
        val result = MutableLiveData<Result<List<UserDomain>?>>()
        result.postValue(Result.Loading)
        launch {
            val toPost = when (val response = userRepository.getUser()) {
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