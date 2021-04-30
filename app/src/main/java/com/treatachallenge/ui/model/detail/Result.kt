package com.treatachallenge.ui.model.detail


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("AccessLevelTypeID")
    val accessLevelTypeID: Int,
    @SerializedName("AssetDomain")
    val assetDomain: String,
    @SerializedName("AttachmentList")
    val attachmentList: List<Attachment>,
    @SerializedName("AttachmentQuality")
    val attachmentQuality: List<AttachmentQuality>,
    @SerializedName("AuthorList")
    val authorList: List<Author>,
    @SerializedName("Available")
    val available: Boolean,
    @SerializedName("Body")
    val body: String,
    @SerializedName("Categories")
    val categories: List<Category>,
    @SerializedName("CollectionImage")
    val collectionImage: String,
    @SerializedName("CommentCount")
    val commentCount: Int,
    @SerializedName("CommentPermission")
    val commentPermission: Int,
    @SerializedName("CommentTemplateList")
    val commentTemplateList: List<CommentTemplate>,
    @SerializedName("ContentID")
    val contentID: Long,
    @SerializedName("CreateDate")
    val createDate: Int,
    @SerializedName("DirectorList")
    val directorList: List<Director>,
    @SerializedName("DisLikeCount")
    val disLikeCount: Int,
    @SerializedName("DisLikeStatus")
    val disLikeStatus: Boolean,
    @SerializedName("EnglishBody")
    val englishBody: String,
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
    @SerializedName("NarratorList")
    val narratorList: List<Any>,
    @SerializedName("NumberOfSeason")
    val numberOfSeason: Int,
    @SerializedName("PortraitImage")
    val portraitImage: String,
    @SerializedName("PortraitImage9X11")
    val portraitImage9X11: String,
    @SerializedName("Price")
    val price: Int,
    @SerializedName("Properties")
    val properties: List<Property>,
    @SerializedName("SMSOperationCode")
    val sMSOperationCode: String,
    @SerializedName("ShortURL")
    val shortURL: String,
    @SerializedName("SourceSiteLogoUrl")
    val sourceSiteLogoUrl: String,
    @SerializedName("SourceSiteTitle")
    val sourceSiteTitle: String,
    @SerializedName("SourceSiteWebUrl")
    val sourceSiteWebUrl: String,
    @SerializedName("StarsList")
    val starsList: List<Stars>,
    @SerializedName("Summary")
    val summary: String,
    @SerializedName("TagList")
    val tagList: List<Tag>,
    @SerializedName("ThumbImage")
    val thumbImage: String,
    @SerializedName("Title")
    val title: String,
    @SerializedName("TranslatorList")
    val translatorList: List<Any>,
    @SerializedName("Type")
    val type: Int,
    @SerializedName("UpdateDate")
    val updateDate: Int,
    @SerializedName("ViewCount")
    val viewCount: Int,
    @SerializedName("WikiList")
    val wikiList: List<Any>,
    @SerializedName("ZoneID")
    val zoneID: Int
)