package com.treatachallenge.ui.model.detail


import com.google.gson.annotations.SerializedName

data class DetailRequestBody(
    @SerializedName("request")
    val request: Request
)