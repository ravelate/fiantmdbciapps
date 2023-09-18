package com.felina.Fiantmdbmovie.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.felina.Fiantmdbmovie.core.domain.model.Movie
import com.felina.Fiantmdbmovie.core.domain.usecase.MovieUseCase

class DetailMovieViewModel(private val movieUseCase: MovieUseCase) : ViewModel() {
    fun setFavoriteMovie(tourism: Movie, newStatus:Boolean) =
        movieUseCase.setFavoriteMovie(tourism, newStatus)

    fun getAllVideo(videoId: Int) = movieUseCase.getAllVideo(videoId).asLiveData()

    fun getAllReview(videoId: Int) = movieUseCase.getAllReview(videoId).asLiveData()
}

