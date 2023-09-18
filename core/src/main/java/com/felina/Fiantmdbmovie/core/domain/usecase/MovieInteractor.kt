package com.felina.Fiantmdbmovie.core.domain.usecase

import com.felina.Fiantmdbmovie.core.domain.model.Movie
import com.felina.Fiantmdbmovie.core.domain.repository.IMovieRepository

class MovieInteractor(private val movieRepository: IMovieRepository): MovieUseCase {

    override fun getAllMovie() = movieRepository.getAllMovie()

    override fun getFavoriteMovie() = movieRepository.getFavoriteMovie()

    override fun setFavoriteMovie(tourism: Movie, state: Boolean) = movieRepository.setFavoriteMovie(tourism, state)

    override fun getAllVideo(videoId: Int) = movieRepository.getAllVideo(videoId)

    override fun getAllReview(videoId: Int) = movieRepository.getAllReview(videoId)
}