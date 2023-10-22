package com.mahmoudhamdyae.unsplash.ui.home.mvi

import com.mahmoudhamdyae.unsplash.domain.model.Photo

sealed class HomeViewState {
    object Loading: HomeViewState()
    data class Photos(val photos: List<Photo>): HomeViewState()
    data class Error(val error: String): HomeViewState()
}