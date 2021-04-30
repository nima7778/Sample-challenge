package com.treatachallenge.ui.model.list


import com.google.gson.annotations.SerializedName

data class Request(
    @SerializedName("RequestType")
    val requestType: Int,
    @SerializedName("RequestId")
    val requestId: Int ? =null,
    @SerializedName("PageSize")
    val pageSize: Int,
    @SerializedName("PageIndex")
    val pageIndex: Int,
    @SerializedName("OrderBy")
    val orderBy: String,
    @SerializedName("Order")
    val order: String
)