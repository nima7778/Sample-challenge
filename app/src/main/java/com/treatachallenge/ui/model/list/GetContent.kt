package com.treatachallenge.ui.model.list


import com.google.gson.annotations.SerializedName

data class GetContent(
    @SerializedName("AccessLevelTypeID")
    val accessLevelTypeID: Int,
    @SerializedName("Authors")
    val authors: String,
    @SerializedName("Categories")
    val categories: List<Category>,
    @SerializedName("CollectionImage")
    val collectionImage: String,
    @SerializedName("CommentCount")
    val commentCount: Int,
    @SerializedName("ContentID")
    val contentID: Long,
    @SerializedName("CreateDate")
    val createDate: Int,
    @SerializedName("DisLikeCount")
    val disLikeCount: Int,
    @SerializedName("DisLikeStatus")
    val disLikeStatus: Boolean,
    @SerializedName("Duration")
    val duration: Int,
    @SerializedName("EnglishBody")
    val englishBody: Any,
    @SerializedName("FavoriteStatus")
    val favoriteStatus: Boolean,
    @SerializedName("FreeReleaseDate")
    val freeReleaseDate: Any,
    @SerializedName("LandscapeImage")
    val landscapeImage: String,
    @SerializedName("LandscapeImage9X4")
    val landscapeImage9X4: String,
    @SerializedName("LikeCount")
    val likeCount: Int,
    @SerializedName("LikeStatus")
    val likeStatus: Boolean,
    @SerializedName("PortraitImage")
    val portraitImage: String,
    @SerializedName("PortraitImage9X11")
    val portraitImage9X11: String,
    @SerializedName("Price")
    val price: Int,
    @SerializedName("Properties")
    val properties: List<Property>,
    @SerializedName("PurchasedPrice")
    val purchasedPrice: Int,
    @SerializedName("SourceSiteLogoUrl")
    val sourceSiteLogoUrl: String,
    @SerializedName("SourceSiteTitle")
    val sourceSiteTitle: String,
    @SerializedName("SourceSiteWebUrl")
    val sourceSiteWebUrl: String,
    @SerializedName("Summary")
    val summary: String,
    @SerializedName("SupplierID")
    val supplierID: Int,
    @SerializedName("TagList")
    val tagList: List<Tag>,
    @SerializedName("TeacherList")
    val teacherList: List<Any>,
    @SerializedName("ThumbImage")
    val thumbImage: String,
    @SerializedName("Title")
    val title: String,
    @SerializedName("Type")
    val type: Int,
    @SerializedName("UpdateDate")
    val updateDate: Long,
    @SerializedName("ViewCount")
    val viewCount: Int,
    @SerializedName("ZoneID")
    val zoneID: Int
)