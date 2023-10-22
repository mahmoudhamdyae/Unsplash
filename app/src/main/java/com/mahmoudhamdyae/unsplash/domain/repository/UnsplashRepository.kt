package com.mahmoudhamdyae.unsplash.domain.repository

import com.mahmoudhamdyae.unsplash.domain.model.Photos

interface UnsplashRepository {

    suspend fun getPhotos(): Photos
}