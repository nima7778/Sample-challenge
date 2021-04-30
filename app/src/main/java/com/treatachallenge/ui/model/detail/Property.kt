package com.treatachallenge.ui.model.detail


import com.google.gson.annotations.SerializedName

data class Property(
    @SerializedName("Name")
    val name: String,
    @SerializedName("PropertyId")
    val propertyId: Int,
    @SerializedName("Value")
    val value: String
)