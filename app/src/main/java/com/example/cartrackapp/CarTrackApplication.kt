package com.example.cartrackapp

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class CarTrackApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@CarTrackApplication)
//            modules(viewModelModule, repositoryModule, serviceModule, useCaseModule)
        }
    }

}