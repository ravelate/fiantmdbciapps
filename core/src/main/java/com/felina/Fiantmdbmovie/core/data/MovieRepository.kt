package com.felina.Fiantmdbmovie.core.data

import com.felina.Fiantmdbmovie.core.data.source.local.LocalDataSource
import com.felina.Fiantmdbmovie.core.data.source.remote.RemoteDataSource
import com.felina.Fiantmdbmovie.core.data.source.remote.network.ApiResponse
import com.felina.Fiantmdbmovie.core.data.source.remote.response.MovieResponse
import com.felina.Fiantmdbmovie.core.data.source.remote.response.ReviewResponse
import com.felina.Fiantmdbmovie.core.data.source.remote.response.VideoResponse
import com.felina.Fiantmdbmovie.core.domain.model.Movie
import com.felina.Fiantmdbmovie.core.domain.model.Review
import com.felina.Fiantmdbmovie.core.domain.model.Video
import com.felina.Fiantmdbmovie.core.domain.repository.IMovieRepository
import com.felina.Fiantmdbmovie.core.utils.AppExecutors
import com.felina.Fiantmdbmovie.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MovieRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IMovieRepository {

    override fun getAllMovie(): Flow<Resource<List<Movie>>> =
        object : NetworkBoundResource<List<Movie>, List<MovieResponse>>() {
            override fun loadFromDB(): Flow<List<Movie>> {
                return localDataSource.getAllMovie().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Movie>?): Boolean = true

            override suspend fun createCall(): Flow<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getAllMovie()

            override suspend fun saveCallResult(data: List<MovieResponse>) {
                val tourismList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertMovie(tourismList)
            }
        }.asFlow()

    override fun getFavoriteMovie(): Flow<List<Movie>> {
        return localDataSource.getFavoriteMovie().map {
           DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteMovie(movie: Movie, state: Boolean) {
        val tourismEntity = DataMapper.mapDomainToEntity(movie)
        appExecutors.diskIO().execute { localDataSource.setFavoriteMovie(tourismEntity, state) }
    }

    //Video
    override fun getAllVideo(videoId: Int): Flow<Resource<List<Video>>> =
        object : NetworkBoundResource<List<Video>, List<VideoResponse>>() {
            override fun loadFromDB(): Flow<List<Video>> {
                return localDataSource.getAllVideo(videoId).map {
                    DataMapper.mapVideoEntitiesToDomain(it,videoId)
                }
            }

            override fun shouldFetch(data: List<Video>?): Boolean = true

            override suspend fun createCall(): Flow<ApiResponse<List<VideoResponse>>> =
                remoteDataSource.getAllVideo(videoId)

            override suspend fun saveCallResult(data: List<VideoResponse>) {
                val tourismList = DataMapper.mapVideoResponsesToEntities(data,videoId)
                localDataSource.insertVideo(tourismList)
            }
        }.asFlow()

    //review
    override fun getAllReview(videoId: Int): Flow<Resource<List<Review>>> =
        object : NetworkBoundResource<List<Review>, List<ReviewResponse>>() {
            override fun loadFromDB(): Flow<List<Review>> {
                return localDataSource.getAllReview(videoId).map {
                    DataMapper.mapReviewEntitiesToDomain(it,videoId)
                }
            }

            override fun shouldFetch(data: List<Review>?): Boolean = true

            override suspend fun createCall(): Flow<ApiResponse<List<ReviewResponse>>> =
                remoteDataSource.getAllReview(videoId)

            override suspend fun saveCallResult(data: List<ReviewResponse>) {
                val tourismList = DataMapper.mapReviewResponsesToEntities(data,videoId)
                localDataSource.insertReview(tourismList)
            }
        }.asFlow()
}

