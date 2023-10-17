package com.felina.Fiantmdbmovie.favorite.di

import com.felina.Fiantmdbmovie.favorite.FavoriteViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val FavoriteModule = module {
    viewModel { FavoriteViewModel(get()) }
}