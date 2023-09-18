package com.felina.Fiantmdbmovie.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "video")
data class VideoEntity(

    @PrimaryKey
    @NonNull
    var id: String,

    @ColumnInfo(name = "site")
    var site: String,

    @ColumnInfo(name = "size")
    var size: Int,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "official")
    var official: Boolean,

    @ColumnInfo(name = "type")
    var type: String,

    @ColumnInfo(name = "published_at")
    var publishedAt: String,

    @ColumnInfo(name = "key")
    var key: String,

    @ColumnInfo(name = "video_id")
    var videoId: Int,
)