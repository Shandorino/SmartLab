package com.example.smartlab.di

import com.example.smartlab.domain.useCase.SendCodeUseCase
import com.example.smartlab.domain.useCase.SignInUseCase
import com.example.smartlab.domain.useCase.impl.SendCodeUseCaseImpl
import com.example.smartlab.domain.useCase.impl.SignInUseCaseImpl
import org.koin.dsl.module

val UseCaseModule = module {


    single<SendCodeUseCase> {
        SendCodeUseCaseImpl(get())
    }

    single<SignInUseCase> {
        SignInUseCaseImpl(get())
    }

}