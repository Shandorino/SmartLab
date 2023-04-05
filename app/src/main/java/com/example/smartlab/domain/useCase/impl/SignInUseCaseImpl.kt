package com.example.smartlab.domain.useCase.impl

import com.example.smartlab.data.source.dto.TokenDTO
import com.example.smartlab.domain.repository.ApiRepository
import com.example.smartlab.domain.useCase.SignInUseCase
import com.example.smartlab.util.ResultWrapper

class SignInUseCaseImpl(private val apiRepository: ApiRepository): SignInUseCase {

    override suspend fun invoke(email: String, code: String): ResultWrapper<TokenDTO> = apiRepository.signIn(email, code)
}