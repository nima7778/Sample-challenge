package com.treatachallenge.ui.model.list


import com.google.gson.annotations.SerializedName

data class RequestBodyModel(
    @SerializedName("request")
    val request: Request
)