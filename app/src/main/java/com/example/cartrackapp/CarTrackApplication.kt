package com.example.cartrackapp

import android.app.Application
import com.example.cartrackapp.di.repositoryModule
import com.example.cartrackapp.di.serviceModule
import com.example.cartrackapp.di.useCaseModule
import com.example.cartrackapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class CarTrackApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@CarTrackApplication)
            modules(viewModelModule, repositoryModule, serviceModule, useCaseModule)
        }
    }

}