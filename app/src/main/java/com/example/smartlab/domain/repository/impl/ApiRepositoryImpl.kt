package com.example.smartlab.domain.repository.impl

import com.example.smartlab.data.source.dto.MessageDTO
import com.example.smartlab.data.source.dto.TokenDTO
import com.example.smartlab.data.source.remote.ApiService
import com.example.smartlab.domain.repository.ApiRepository
import com.example.smartlab.util.ResultWrapper
import com.example.smartlab.util.safeApiCall
import kotlinx.coroutines.Dispatchers

class ApiRepositoryImpl(private val apiService: ApiService) : ApiRepository {

    override suspend fun sendCode(email: String): ResultWrapper<MessageDTO> {
        return safeApiCall(Dispatchers.IO) {
            apiService.sendCode(email)
        }
    }

    override suspend fun signIn(email: String, code: String): ResultWrapper<TokenDTO> {
        return safeApiCall(Dispatchers.IO) {
            apiService.signIn(email, code)
        }
    }

    override fun getCatalog() {
        TODO("Not yet implemented")
    }

    override fun getNews() {
        TODO("Not yet implemented")
    }

    override fun createProfile() {
        TODO("Not yet implemented")
    }

    override fun updateProfile() {
        TODO("Not yet implemented")
    }

    override fun postAvatar() {
        TODO("Not yet implemented")
    }

    override fun order() {
        TODO("Not yet implemented")
    }
}