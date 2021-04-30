package com.treatachallenge.ui.model.detail


import com.google.gson.annotations.SerializedName

data class Time(
    @SerializedName("Id")
    val id: Int,
    @SerializedName("Time")
    val time: Int,
    @SerializedName("Title")
    val title: String,
    @SerializedName("Type")
    val type: Type
)