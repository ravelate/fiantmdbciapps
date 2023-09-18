package com.felina.Fiantmdbmovie.di

import com.felina.Fiantmdbmovie.core.domain.usecase.MovieInteractor
import com.felina.Fiantmdbmovie.core.domain.usecase.MovieUseCase
import com.felina.Fiantmdbmovie.detail.DetailMovieViewModel
import com.felina.Fiantmdbmovie.favorite.FavoriteViewModel
import com.felina.Fiantmdbmovie.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<MovieUseCase> { MovieInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { FavoriteViewModel(get()) }
    viewModel { DetailMovieViewModel(get()) }
}