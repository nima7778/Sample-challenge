package com.treatachallenge.ui.model.detail


import com.google.gson.annotations.SerializedName

data class CommentTemplate(
    @SerializedName("Body")
    val body: String,
    @SerializedName("Id")
    val id: Int,
    @SerializedName("TypeId")
    val typeId: Int,
    @SerializedName("TypeTitle")
    val typeTitle: String
)