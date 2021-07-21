package com.example.movieappcleanarch

import android.app.Application
import com.example.movieappcleanarch.di.mainUseCaseModule
import com.example.movieappcleanarch.di.mainViewModelModule
import com.example.movieappcleanarch.di.networkModule
import com.example.movieappcleanarch.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@BaseApplication)
            modules(
                mainViewModelModule,
                mainUseCaseModule,
                repositoryModule,
                networkModule
            )
        }

    }
}