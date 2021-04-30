package com.treatachallenge.ui.model.detail


import com.google.gson.annotations.SerializedName

data class AttachmentQuality(
    @SerializedName("ID")
    val iD: Int,
    @SerializedName("Title")
    val title: String
)