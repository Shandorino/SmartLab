package com.example.smartlab.screenModel

import androidx.compose.runtime.mutableStateOf
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import com.example.smartlab.domain.useCase.SendCodeUseCase
import com.example.smartlab.util.ResultWrapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AuthScreenModel(
    private val getCodeUseCase: SendCodeUseCase
): ScreenModel {

    private val text = MutableStateFlow("")
    val text_ = text.asStateFlow()

    var emailCash = MutableStateFlow("")

    val isSuc = MutableStateFlow(false)

    fun getCode(email: String) {

        coroutineScope.launch {
            withContext(Dispatchers.IO) {

                when(val result = getCodeUseCase.invoke(email)) {

                    is ResultWrapper.Success -> {

                        isSuc.value = true

                        delay(300)

                        isSuc.value = false

                    }
                    else -> {
                        if (result is ResultWrapper.GenericError) {

                                text.value = result.error.toString()

                        }
                        else if (result is ResultWrapper.NetworkError) {

                                text.value = "Ошибка сети"

                        }

                    }
                }
            }


        }
    }

}