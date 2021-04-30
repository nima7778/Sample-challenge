package com.treatachallenge.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorites")
data class MovieEntity(
    @ColumnInfo(name = "content_id")
    @PrimaryKey(autoGenerate = false)
    val contentId: Long,
    @ColumnInfo(name = "image_url")
    val image: String,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "type")
    val type: Int
)
