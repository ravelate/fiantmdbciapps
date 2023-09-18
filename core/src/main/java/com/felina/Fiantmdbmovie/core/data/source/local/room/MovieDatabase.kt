package com.felina.Fiantmdbmovie.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.felina.Fiantmdbmovie.core.data.source.local.entity.MovieEntity
import com.felina.Fiantmdbmovie.core.data.source.local.entity.ReviewEntity
import com.felina.Fiantmdbmovie.core.data.source.local.entity.VideoEntity

@Database(entities = [MovieEntity::class, VideoEntity::class, ReviewEntity::class], version = 1, exportSchema = false)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

}