package com.example.smartlab.domain.useCase

import com.example.smartlab.data.source.dto.TokenDTO
import com.example.smartlab.util.ResultWrapper

interface SignInUseCase {


    suspend operator fun invoke(email: String, code: String): ResultWrapper<TokenDTO>


}