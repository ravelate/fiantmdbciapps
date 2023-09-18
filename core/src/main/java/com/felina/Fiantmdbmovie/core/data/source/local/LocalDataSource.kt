package com.felina.Fiantmdbmovie.core.data.source.local

import com.felina.Fiantmdbmovie.core.data.source.local.entity.MovieEntity
import com.felina.Fiantmdbmovie.core.data.source.local.entity.ReviewEntity
import com.felina.Fiantmdbmovie.core.data.source.local.entity.VideoEntity
import com.felina.Fiantmdbmovie.core.data.source.local.room.MovieDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val movieDao: MovieDao) {

    fun getAllMovie(): Flow<List<MovieEntity>> = movieDao.getAllMovie()

    fun getFavoriteMovie(): Flow<List<MovieEntity>> = movieDao.getFavoriteMovie()

    suspend fun insertMovie(tourismList: List<MovieEntity>) = movieDao.insertMovie(tourismList)

    fun setFavoriteMovie(movie: MovieEntity, newState: Boolean) {
        movie.isFavorite = newState
        movieDao.updateFavoriteMovie(movie)
    }

    fun getAllVideo(input: Int): Flow<List<VideoEntity>> = movieDao.getAllVideo(input)

    suspend fun insertVideo(tourismList: List<VideoEntity>) = movieDao.insertVideo(tourismList)

    fun getAllReview(input: Int): Flow<List<ReviewEntity>> = movieDao.getAllReview(input)

    suspend fun insertReview(tourismList: List<ReviewEntity>) = movieDao.insertReview(tourismList)
}