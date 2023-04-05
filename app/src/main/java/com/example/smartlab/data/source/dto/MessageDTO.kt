package com.example.smartlab.data.source.dto


import com.google.gson.annotations.SerializedName

data class MessageDTO(
    @SerializedName("message")
    val message: String
)