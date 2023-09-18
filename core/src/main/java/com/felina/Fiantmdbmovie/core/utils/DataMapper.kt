package com.felina.Fiantmdbmovie.core.utils

import com.felina.Fiantmdbmovie.core.data.source.local.entity.MovieEntity
import com.felina.Fiantmdbmovie.core.data.source.local.entity.ReviewEntity
import com.felina.Fiantmdbmovie.core.data.source.local.entity.VideoEntity
import com.felina.Fiantmdbmovie.core.data.source.remote.response.MovieResponse
import com.felina.Fiantmdbmovie.core.data.source.remote.response.ReviewResponse
import com.felina.Fiantmdbmovie.core.data.source.remote.response.VideoResponse
import com.felina.Fiantmdbmovie.core.domain.model.Movie
import com.felina.Fiantmdbmovie.core.domain.model.Review
import com.felina.Fiantmdbmovie.core.domain.model.Video

object DataMapper {
    fun mapResponsesToEntities(input: List<MovieResponse>): List<MovieEntity> {
        val movieList = ArrayList<MovieEntity>()
        input.map {
            val movie = MovieEntity(
                id = it.id,
                overview = it.overview,
                video = it.video,
                title = it.title,
                posterPath = it.posterPath,
                releaseDate = it.releaseDate,
                voteAverage = it.voteAverage,
                voteCount = it.voteCount,
                isFavorite = false
            )
            movieList.add(movie)
        }
        return movieList
    }
    fun mapEntitiesToDomain(input: List<MovieEntity>): List<Movie> =
        input.map {
            Movie(
                id = it.id,
                overview = it.overview,
                video = it.video,
                title = it.title,
                posterPath = it.posterPath,
                releaseDate = it.releaseDate,
                voteAverage = it.voteAverage,
                voteCount = it.voteCount,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Movie) = MovieEntity(
        id = input.id,
        overview = input.overview,
        video = input.video,
        title = input.title,
        posterPath = input.posterPath,
        releaseDate = input.releaseDate,
        voteAverage = input.voteAverage,
        voteCount = input.voteCount,
        isFavorite = input.isFavorite
    )

    //Video
    fun mapVideoResponsesToEntities(input: List<VideoResponse>,videoId: Int): List<VideoEntity> {
        val videoList = ArrayList<VideoEntity>()
        input.map {
            val video = VideoEntity(
                id = it.id,
                site = it.site,
                size = it.size,
                name = it.name,
                official = it.official,
                type = it.type,
                publishedAt = it.publishedAt,
                key = it.key,
                videoId = videoId
            )
            videoList.add(video)
        }
        return videoList
    }

    fun mapVideoEntitiesToDomain(input: List<VideoEntity>, videoId: Int): List<Video> =
        input.map {
            Video(
                id = it.id,
                site = it.site,
                size = it.size,
                name = it.name,
                official = it.official,
                type = it.type,
                publishedAt = it.publishedAt,
                key = it.key,
                videoId = videoId
            )
        }
    //Review
    fun mapReviewResponsesToEntities(input: List<ReviewResponse>,videoId: Int): List<ReviewEntity> {
        val reviewList = ArrayList<ReviewEntity>()
        input.map {
            val review = ReviewEntity(
                id = it.id,
                updatedAt = it.updatedAt,
                author = it.author,
                createdAt = it.createdAt,
                content = it.content,
                url = it.url,
                movieId = videoId,
            )
            reviewList.add(review)
        }
        return reviewList
    }

    fun mapReviewEntitiesToDomain(input: List<ReviewEntity>, videoId: Int): List<Review> =
        input.map {
            Review(
                id = it.id,
                updatedAt = it.updatedAt,
                author = it.author,
                createdAt = it.createdAt,
                content = it.content,
                url = it.url,
                movieId = videoId,
            )
        }
}