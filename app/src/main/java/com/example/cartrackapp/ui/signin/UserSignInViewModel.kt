package com.example.cartrackapp.ui.signin

import androidx.lifecycle.*
import com.example.cartrackapp.clean_architecture.Result
import com.example.cartrackapp.domain.interactors.UserLoginUseCase
import com.example.cartrackapp.domain.model.UserDomain
import com.example.cartrackapp.room_database.UserDB

class UserSignInViewModel(private var userLoginUseCase: UserLoginUseCase) : ViewModel() {

    //    Inputs
    val onGetUsers = MutableLiveData<Unit>()

    //Outputs
    internal val onUsersDBListLoaded: LiveData<List<UserDB>?> get() = _onUsersLoaded

    // Transformations
    private val getUsersResult: LiveData<Result<List<UserDB>>> = Transformations.switchMap(onGetUsers) {
        userLoginUseCase.execute()
    }

    private val _onUsersLoaded = MediatorLiveData<List<UserDB>>()

    init {
        _onUsersLoaded.addSource(getUsersResult) {
            if (it is Result.Success) {
                _onUsersLoaded.postValue(
                    it.data
                )
            }
        }
    }
}