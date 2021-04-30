package com.treatachallenge.ui.model.detail


import com.google.gson.annotations.SerializedName

data class File(
    @SerializedName("CdnType")
    val cdnType: Int,
    @SerializedName("Description")
    val description: String,
    @SerializedName("Duration")
    val duration: Int,
    @SerializedName("FileExtension")
    val fileExtension: String,
    @SerializedName("Path")
    val path: String,
    @SerializedName("Quality")
    val quality: Int,
    @SerializedName("Size")
    val size: Int,
    @SerializedName("Thumbnail")
    val thumbnail: String,
    @SerializedName("Times")
    val times: List<Time>,
    @SerializedName("Type")
    val type: Int,
    @SerializedName("UniqueId")
    val uniqueId: Int,
    @SerializedName("ViewCount")
    val viewCount: Int
)