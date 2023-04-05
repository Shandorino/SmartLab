package com.example.smartlab.domain.repository

import com.example.smartlab.data.source.dto.MessageDTO
import com.example.smartlab.data.source.dto.TokenDTO
import com.example.smartlab.data.source.remote.ApiService
import com.example.smartlab.util.ResultWrapper

interface ApiRepository {


    suspend fun sendCode(email: String): ResultWrapper<MessageDTO>

    suspend fun signIn(email: String, code: String): ResultWrapper<TokenDTO>

    fun getCatalog()

    fun getNews()

    fun createProfile()

    fun updateProfile()

    fun postAvatar()

    fun order()

}