package com.example.smartlab.data.source.dto


import com.google.gson.annotations.SerializedName

data class NewsDTO(
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: String
)