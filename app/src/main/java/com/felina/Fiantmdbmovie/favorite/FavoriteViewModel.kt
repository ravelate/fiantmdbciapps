package com.felina.Fiantmdbmovie.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.felina.Fiantmdbmovie.core.domain.usecase.MovieUseCase

class FavoriteViewModel(movieUseCase: MovieUseCase) : ViewModel() {
    val favoriteTourism = movieUseCase.getFavoriteMovie().asLiveData()
}

