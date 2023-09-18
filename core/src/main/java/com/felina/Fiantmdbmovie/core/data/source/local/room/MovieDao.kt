package com.felina.Fiantmdbmovie.core.data.source.local.room

import androidx.room.*
import com.felina.Fiantmdbmovie.core.data.source.local.entity.MovieEntity
import com.felina.Fiantmdbmovie.core.data.source.local.entity.ReviewEntity
import com.felina.Fiantmdbmovie.core.data.source.local.entity.VideoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie")
    fun getAllMovie(): Flow<List<MovieEntity>>

    @Query("SELECT * FROM movie where isFavorite = 1")
    fun getFavoriteMovie(): Flow<List<MovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(tourism: List<MovieEntity>)

    @Update
    fun updateFavoriteMovie(tourism: MovieEntity)

    @Query("SELECT * FROM video where video_id = :input")
    fun getAllVideo(input: Int): Flow<List<VideoEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVideo(tourism: List<VideoEntity>)

    @Query("SELECT * FROM review where movie_id = :input")
    fun getAllReview(input: Int): Flow<List<ReviewEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertReview(tourism: List<ReviewEntity>)

}
