package com.example.smartlab.di

import com.example.smartlab.data.source.remote.ApiService
import com.example.smartlab.data.source.remote.ApiServiceImpl
import com.example.smartlab.domain.repository.ApiRepository
import com.example.smartlab.domain.repository.impl.ApiRepositoryImpl
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.gson.*
import org.koin.dsl.module


val ApiServiceModule = module {


    single<ApiRepository> {
        ApiRepositoryImpl(get())
    }

    single<ApiService> {
        ApiServiceImpl(get())
    }

    single {
        HttpClient(Android){
            install(ContentNegotiation) {
                gson()
            }
            expectSuccess = true
        }
    }



}