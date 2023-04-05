package com.example.smartlab.domain.useCase.impl

import com.example.smartlab.data.source.dto.MessageDTO
import com.example.smartlab.domain.repository.ApiRepository
import com.example.smartlab.domain.useCase.SendCodeUseCase
import com.example.smartlab.util.ResultWrapper

class SendCodeUseCaseImpl(private val apiRepository: ApiRepository): SendCodeUseCase {

    override suspend fun invoke(email: String): ResultWrapper<MessageDTO> {
        return apiRepository.sendCode(email)
    }
}