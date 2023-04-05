package com.example.smartlab.data.source.remote

import com.example.smartlab.data.source.dto.MessageDTO
import com.example.smartlab.data.source.dto.TokenDTO
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

class ApiServiceImpl(override val httpClient: HttpClient): ApiService {

    override suspend fun sendCode(email: String): MessageDTO {


        val response: HttpResponse = httpClient.post() {
            url {
                protocol = URLProtocol.HTTPS
                host = "medic.madskill.ru"
                path("api/sendCode")
            }
            header("email", email)
        }

        when (response.status.value) {

            in 200..210 -> {
                return response.body()
            }
            in 300..350 -> {
                throw RedirectResponseException(response, "Code: ${response.status.value}")
            }
            in 400..450 -> {
                throw ClientRequestException(response, "Code: ${response.status.value}")
            }
            else -> {
                throw ServerResponseException(response, "Code: ${response.status.value}")
            }
        }

    }

    override suspend fun signIn(email: String, code: String): TokenDTO {
        val response: HttpResponse = httpClient.post() {
            url {
                protocol = URLProtocol.HTTPS
                host = "medic.madskill.ru"
                path("api/signin")
            }
            headers {
                header("email", email)
                header("code", code)
            }
        }

        when (response.status.value) {

            in 200..210 -> {
                return response.body()
            }
            in 300..350 -> {
                throw RedirectResponseException(response, "Code: ${response.status.value}")
            }
            in 400..450 -> {
                throw ClientRequestException(response, "Code: ${response.status.value}")
            }
            else -> {
                throw ServerResponseException(response, "Code: ${response.status.value}")
            }
        }
    }


}