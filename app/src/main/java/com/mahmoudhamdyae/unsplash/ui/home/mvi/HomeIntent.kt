package com.mahmoudhamdyae.unsplash.ui.home.mvi

sealed class HomeIntent {
    object GetPhotos : HomeIntent()
}