package com.example.kotlinmvvmretrofill.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class KoinAplication:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@KoinAplication)
            modules(
                listOf(covidModule,viewModelModuel)
            )
        }
    }
}