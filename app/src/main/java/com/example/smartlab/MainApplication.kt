package com.example.smartlab

import android.app.Application
import com.example.smartlab.di.ApiServiceModule
import com.example.smartlab.di.ScreenModelModule
import com.example.smartlab.di.UseCaseModule
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {

            modules(listOf(ScreenModelModule, ApiServiceModule, UseCaseModule))

        }


    }



}