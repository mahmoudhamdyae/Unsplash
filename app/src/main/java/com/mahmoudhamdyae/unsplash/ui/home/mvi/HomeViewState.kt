package com.mahmoudhamdyae.unsplash.ui.home.mvi

import com.mahmoudhamdyae.unsplash.domain.model.Photo

data class HomeViewState (
    val isLoading: Boolean = true,
    val error: String? = null,
    val photos: List<Photo> = listOf()
)