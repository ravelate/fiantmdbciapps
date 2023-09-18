package com.felina.Fiantmdbmovie.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.felina.Fiantmdbmovie.core.domain.usecase.MovieUseCase

class HomeViewModel(movieUseCase: MovieUseCase) : ViewModel() {
    val tourism = movieUseCase.getAllMovie().asLiveData()
}

