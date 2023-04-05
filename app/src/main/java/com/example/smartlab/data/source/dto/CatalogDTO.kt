package com.example.smartlab.data.source.dto


import com.google.gson.annotations.SerializedName

data class CatalogDTO(
    @SerializedName("bio")
    val bio: String,
    @SerializedName("category")
    val category: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("preparation")
    val preparation: String,
    @SerializedName("price")
    val price: String,
    @SerializedName("time_result")
    val timeResult: String
)