package com.treatachallenge.ui.model.detail


import com.google.gson.annotations.SerializedName

data class Request(
    @SerializedName("RequestID")
    val requestID: Long? =null
)