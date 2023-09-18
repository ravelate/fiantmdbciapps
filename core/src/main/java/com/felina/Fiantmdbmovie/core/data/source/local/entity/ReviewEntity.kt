package com.felina.Fiantmdbmovie.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "review")
data class ReviewEntity(
    @PrimaryKey
    @NonNull
    val id: String,
    @ColumnInfo(name = "updated_at")
    val updatedAt: String,
    @ColumnInfo(name = "author")
    val author: String,
    @ColumnInfo(name = "created_at")
    val createdAt: String,
    @ColumnInfo(name = "content")
    val content: String,
    @ColumnInfo(name = "url")
    val url: String,
    @ColumnInfo(name = "movie_id")
    val movieId: Int,
)
