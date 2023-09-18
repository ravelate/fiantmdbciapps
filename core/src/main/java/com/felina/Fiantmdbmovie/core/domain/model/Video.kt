package com.felina.Fiantmdbmovie.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Video(
    val id: String,
    val site: String,
    val size: Int,
    val name: String,
    val official: Boolean,
    val type: String,
    val publishedAt: String,
    val key: String,
    val videoId: Int,
): Parcelable