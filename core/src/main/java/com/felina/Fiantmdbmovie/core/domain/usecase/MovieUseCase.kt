package com.felina.Fiantmdbmovie.core.domain.usecase

import com.felina.Fiantmdbmovie.core.data.Resource
import com.felina.Fiantmdbmovie.core.domain.model.Movie
import com.felina.Fiantmdbmovie.core.domain.model.Review
import com.felina.Fiantmdbmovie.core.domain.model.Video
import kotlinx.coroutines.flow.Flow

interface MovieUseCase {
    fun getAllMovie(): Flow<Resource<List<Movie>>>
    fun getFavoriteMovie(): Flow<List<Movie>>
    fun setFavoriteMovie(tourism: Movie, state: Boolean)

    fun getAllVideo(videoId: Int): Flow<Resource<List<Video>>>
    fun getAllReview(videoId: Int): Flow<Resource<List<Review>>>
}