package com.treatachallenge.ui.model.list


import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("AgeRangeId")
    val ageRangeId: Any,
    @SerializedName("CategoryID")
    val categoryID: Int,
    @SerializedName("DefaultImage")
    val defaultImage: String,
    @SerializedName("HasCopyRight")
    val hasCopyRight: Boolean,
    @SerializedName("Image")
    val image: String,
    @SerializedName("IsFollowed")
    val isFollowed: Any,
    @SerializedName("IsSelected")
    val isSelected: Boolean,
    @SerializedName("ParentID")
    val parentID: Int,
    @SerializedName("SectionPriority")
    val sectionPriority: Int,
    @SerializedName("Title")
    val title: String,
    @SerializedName("ZoneID")
    val zoneID: Int
)