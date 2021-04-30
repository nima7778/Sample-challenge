package com.treatachallenge.ui.model.detail


import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("CategoryID")
    val categoryID: Int,
    @SerializedName("ParentID")
    val parentID: Int,
    @SerializedName("Title")
    val title: String,
    @SerializedName("ZoneID")
    val zoneID: Int
)