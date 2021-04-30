package com.treatachallenge.ui.model.list


import com.google.gson.annotations.SerializedName

data class ResponseModel(
    @SerializedName("Message")
    val message: String,
    @SerializedName("Result")
    val result: Result,
    @SerializedName("Status")
    val status: Int
)