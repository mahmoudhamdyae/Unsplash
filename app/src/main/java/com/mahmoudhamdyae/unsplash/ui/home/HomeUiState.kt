package com.mahmoudhamdyae.unsplash.ui.home

import com.mahmoudhamdyae.unsplash.domain.model.Photo

data class HomeUiState(
    val photos: List<Photo> = listOf(),
    val isLoading: Boolean = false,
    val error: String? = null
)