package com.felina.Fiantmdbmovie.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val id: Int,
    val overview: String,
    val video: Boolean,
    val title: String,
    val posterPath: String,
    val releaseDate: String,
    val voteAverage: Double,
    val voteCount: Int,
    val isFavorite: Boolean
): Parcelable