package com.example.cartrackapp.di

import com.example.cartrackapp.domain.interactors.GetUsersUseCase
import com.example.cartrackapp.domain.interactors.RegisterUserUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetUsersUseCase(get()) }
    factory { RegisterUserUseCase(get(), get()) }
}