package com.example.smartlab.data.source.dto


import com.google.gson.annotations.SerializedName

data class SignInDTO(
    @SerializedName("code")
    val code: String,
    @SerializedName("email")
    val email: String
)