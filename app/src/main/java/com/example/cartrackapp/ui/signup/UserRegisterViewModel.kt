package com.example.cartrackapp.ui.signup

import androidx.lifecycle.*
import com.example.cartrackapp.clean_architecture.Result
import com.example.cartrackapp.domain.interactors.RegisterUserUseCase
import com.example.cartrackapp.domain.model.UserDomain
import com.example.cartrackapp.room_database.UserDB

class UserRegisterViewModel(private val userUseCase: RegisterUserUseCase) : ViewModel() {

    // Inputs
    val onUserRegister = MutableLiveData<UserDB>()

    //Outputs
    internal val onUserRegistered: LiveData<Boolean> get() = _onUserRegister

    // Transformations
    private val getUserRegisterResult: LiveData<Result<Boolean>> = Transformations.switchMap(onUserRegister) {
        userUseCase.execute(it)
    }

    private val _onUserRegister = MediatorLiveData<Boolean>()

    init {
        _onUserRegister.addSource(getUserRegisterResult) {
            if (it is Result.Success) {
                _onUserRegister.postValue(
                    it.data
                )
            }
        }
    }
}