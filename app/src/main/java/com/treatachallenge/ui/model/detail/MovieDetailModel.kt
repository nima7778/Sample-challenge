package com.treatachallenge.ui.model.detail


import com.google.gson.annotations.SerializedName

data class MovieDetailModel(
    @SerializedName("Message")
    val message: String,
    @SerializedName("Result")
    val result: Result,
    @SerializedName("Status")
    val status: Int
)