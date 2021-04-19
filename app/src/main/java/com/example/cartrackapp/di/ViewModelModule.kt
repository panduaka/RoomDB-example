package com.example.cartrackapp.di


import com.example.cartrackapp.ui.main.MainActivityViewModel
import com.example.cartrackapp.ui.signin.UserSignInViewModel
import com.example.cartrackapp.ui.signup.UserRegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainActivityViewModel(get()) }
    viewModel { UserRegisterViewModel(get()) }
    viewModel { UserSignInViewModel(get()) }
}