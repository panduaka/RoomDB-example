package com.example.cartrackapp.ui

import androidx.lifecycle.ViewModel
import com.example.cartrackapp.domain.interactors.GetUsersUseCase

class MainActivityViewModel(private val getUsersUseCase: GetUsersUseCase): ViewModel() {

    fun getUsers(){
        getUsersUseCase.execute()
    }
}