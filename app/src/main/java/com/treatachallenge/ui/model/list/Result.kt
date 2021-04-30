package com.treatachallenge.ui.model.list


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("GetContentList")
    val getContentList: List<GetContent>,
    @SerializedName("TotalPages")
    val totalPages: Int
)