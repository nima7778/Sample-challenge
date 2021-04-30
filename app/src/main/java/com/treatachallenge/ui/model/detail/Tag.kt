package com.treatachallenge.ui.model.detail


import com.google.gson.annotations.SerializedName

data class Tag(
    @SerializedName("BackgroundImage")
    val backgroundImage: String,
    @SerializedName("Description")
    val description: Any,
    @SerializedName("Image")
    val image: String,
    @SerializedName("IsFollowed")
    val isFollowed: Any,
    @SerializedName("IsSelected")
    val isSelected: Boolean,
    @SerializedName("Name")
    val name: String,
    @SerializedName("SectionPriority")
    val sectionPriority: Int,
    @SerializedName("TagId")
    val tagId: Int
)