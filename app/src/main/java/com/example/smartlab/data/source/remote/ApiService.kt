package com.example.smartlab.data.source.remote

import com.example.smartlab.data.source.dto.MessageDTO
import com.example.smartlab.data.source.dto.TokenDTO
import io.ktor.client.*

interface ApiService {

    val httpClient: HttpClient

    suspend fun sendCode(email: String): MessageDTO

    suspend fun signIn(email: String, code: String): TokenDTO

}

