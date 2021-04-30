package com.treatachallenge.ui.model.detail


import com.google.gson.annotations.SerializedName

data class Attachment(
    @SerializedName("Available")
    val available: Boolean,
    @SerializedName("Description")
    val description: String,
    @SerializedName("Duration")
    val duration: Int,
    @SerializedName("FileExtension")
    val fileExtension: String,
    @SerializedName("Files")
    val files: List<File>,
    @SerializedName("IsDubbed")
    val isDubbed: Boolean,
    @SerializedName("IsFree")
    val isFree: Boolean,
    @SerializedName("LastVisitEndSecond")
    val lastVisitEndSecond: Int,
    @SerializedName("PartNo")
    val partNo: Int,
    @SerializedName("Title")
    val title: String,
    @SerializedName("Type")
    val type: Int,
    @SerializedName("ViewCount")
    val viewCount: Int
)