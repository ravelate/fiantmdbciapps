package com.felina.Fiantmdbmovie

import android.app.Application
import com.felina.Fiantmdbmovie.core.di.databaseModule
import com.felina.Fiantmdbmovie.core.di.networkModule
import com.felina.Fiantmdbmovie.core.di.repositoryModule
import com.felina.Fiantmdbmovie.di.useCaseModule
import com.felina.Fiantmdbmovie.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}