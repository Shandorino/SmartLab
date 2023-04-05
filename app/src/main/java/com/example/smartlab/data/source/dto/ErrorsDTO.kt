package com.example.smartlab.data.source.dto


import com.google.gson.annotations.SerializedName

data class ErrorsDTO(
    @SerializedName("errors")
    val errors: List<String>
)