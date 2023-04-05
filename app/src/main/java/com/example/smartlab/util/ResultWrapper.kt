package com.example.smartlab.util

import android.util.Log
import com.example.smartlab.data.source.dto.ErrorsDTO
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.statement.*
import io.ktor.utils.io.errors.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

sealed class Result<out T : Any> {
    data class Success<out T : Any>(val value: T) : Result<T>()
    data class Error(val message: String) : Result<Nothing>()
    object Loading : Result<Nothing>()
}

sealed class ResultWrapper<out T> {
    data class Success<out T>(val value: T) : ResultWrapper<T>()
    data class GenericError(val error: String? = null) :
        ResultWrapper<Nothing>()

    object NetworkError : ResultWrapper<Nothing>()
}

suspend fun <T> safeApiCall(
    dispatcher: CoroutineDispatcher,
    apiCall: suspend () -> T
): ResultWrapper<T> {
    return withContext(dispatcher) {
        try {
            ResultWrapper.Success(apiCall.invoke())
        } catch (throwable: Throwable) {
            when (throwable) {
                is IOException -> ResultWrapper.NetworkError
                is ClientRequestException -> {
                    val errorResponse: ErrorsDTO = throwable.response.body()
                    ResultWrapper.GenericError(errorResponse.errors[0])
                }
                is RedirectResponseException -> {
                    ResultWrapper.GenericError(throwable.response.status.value.toString())
                }
                is ServerResponseException -> {
                    ResultWrapper.GenericError(throwable.response.status.value.toString())
                }
                else -> {
                    ResultWrapper.GenericError(null)
                }
            }
        }
    }
}