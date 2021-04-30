package com.treatachallenge.ui.model.list


import com.google.gson.annotations.SerializedName

data class Tag(
    @SerializedName("BackgroundImage")
    val backgroundImage: String,
    @SerializedName("Description")
    val description: Any,
    @SerializedName("Image")
    val image: String,
    @SerializedName("IsFollowed")
    val isFollowed: Boolean,
    @SerializedName("IsSelected")
    val isSelected: Boolean,
    @SerializedName("Name")
    val name: String,
    @SerializedName("SectionPriority")
    val sectionPriority: Int,
    @SerializedName("TagId")
    val tagId: Int
)