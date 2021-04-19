package com.example.cartrackapp.di

import com.example.cartrackapp.data.UserLoginRepositoryImpl
import com.example.cartrackapp.data.UserRegisterRepositoryImpl
import com.example.cartrackapp.data.UserRepositoryImpl
import com.example.cartrackapp.data.service.CarTrackService
import com.example.cartrackapp.domain.repository.LoginRepository
import com.example.cartrackapp.domain.repository.UserRegisterRepository
import com.example.cartrackapp.domain.repository.UserRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { UserRepositoryImpl(get()) as UserRepository }
    single { UserRegisterRepositoryImpl() as UserRegisterRepository }
    single { UserLoginRepositoryImpl() as LoginRepository }
}

val serviceModule = module {
    single { CarTrackService.create() }
}