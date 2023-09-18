package com.felina.Fiantmdbmovie.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Review(
    val id: String,
    val updatedAt: String,
    val author: String,
    val createdAt: String,
    val content: String,
    val url: String,
    val movieId: Int,
): Parcelable
