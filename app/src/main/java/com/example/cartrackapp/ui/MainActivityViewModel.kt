package com.example.cartrackapp.ui

import androidx.lifecycle.*
import com.example.cartrackapp.domain.interactors.GetUsersUseCase
import com.example.cartrackapp.domain.model.UserDomain
import com.example.cartrackapp.clean_architecture.Result

class MainActivityViewModel(private val getUsersUseCase: GetUsersUseCase) : ViewModel() {


    //    Inputs
    val onGetUsers = MutableLiveData<Unit>()

    //Outputs
    internal val onUsersLoaded: LiveData<List<UserDomain>?> get() = _onUsersLoaded

    // Transformations
    private val getUsersResult: LiveData<Result<List<UserDomain>?>> = Transformations.switchMap(onGetUsers) {
        getUsersUseCase.execute()
    }

    private val _onUsersLoaded = MediatorLiveData<List<UserDomain>>()

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