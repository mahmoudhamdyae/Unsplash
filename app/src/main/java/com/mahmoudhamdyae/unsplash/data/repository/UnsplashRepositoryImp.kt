package com.mahmoudhamdyae.unsplash.data.repository

import com.mahmoudhamdyae.unsplash.data.remote.ApiService
import com.mahmoudhamdyae.unsplash.domain.repository.UnsplashRepository
import javax.inject.Inject

class UnsplashRepositoryImp @Inject constructor(
    private val apiService: ApiService
): UnsplashRepository {

    override suspend fun getPhotos() = apiService.getPhotos()
}