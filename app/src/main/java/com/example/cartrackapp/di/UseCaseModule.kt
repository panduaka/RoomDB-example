package com.example.cartrackapp.di

import com.example.cartrackapp.domain.interactors.GetUsersUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetUsersUseCase(get()) }
}