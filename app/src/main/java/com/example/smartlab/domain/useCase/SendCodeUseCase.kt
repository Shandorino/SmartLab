package com.example.smartlab.domain.useCase

import com.example.smartlab.data.source.dto.MessageDTO
import com.example.smartlab.util.ResultWrapper

interface SendCodeUseCase {

    suspend operator fun invoke(email: String): ResultWrapper<MessageDTO>

}