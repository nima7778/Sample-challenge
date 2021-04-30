package com.treatachallenge.ui.model.detail


import com.google.gson.annotations.SerializedName

data class Type(
    @SerializedName("Id")
    val id: Int,
    @SerializedName("Title")
    val title: String
)