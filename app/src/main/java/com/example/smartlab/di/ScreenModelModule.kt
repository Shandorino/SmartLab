package com.example.smartlab.di

import com.example.smartlab.screenModel.AuthScreenModel
import org.koin.dsl.module


val ScreenModelModule = module {

    factory { AuthScreenModel(get()) }

}