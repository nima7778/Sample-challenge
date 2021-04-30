package com.treatachallenge.ui.model.detail


import com.google.gson.annotations.SerializedName

data class Director(
    @SerializedName("AvatarUrl")
    val avatarUrl: String,
    @SerializedName("BirthDate")
    val birthDate: Int,
    @SerializedName("Children")
    val children: List<Any>,
    @SerializedName("ContentID")
    val contentID: Int,
    @SerializedName("ContentPersonId")
    val contentPersonId: Int,
    @SerializedName("DeathDate")
    val deathDate: Int,
    @SerializedName("EnglishName")
    val englishName: String,
    @SerializedName("ID")
    val iD: Int,
    @SerializedName("LikeStatus")
    val likeStatus: Boolean,
    @SerializedName("Nationality")
    val nationality: Any,
    @SerializedName("NickName")
    val nickName: Any,
    @SerializedName("OtherInfo")
    val otherInfo: Any,
    @SerializedName("ParentId")
    val parentId: Any,
    @SerializedName("PersianName")
    val persianName: String,
    @SerializedName("PersonRoleId")
    val personRoleId: Int
)