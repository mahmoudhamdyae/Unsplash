package com.mahmoudhamdyae.unsplash.domain.usecase

import com.mahmoudhamdyae.unsplash.domain.model.Photo
import com.mahmoudhamdyae.unsplash.domain.repository.UnsplashRepository
import com.mahmoudhamdyae.unsplash.util.Result
import javax.inject.Inject

class GetPhotosUseCase @Inject constructor(
    private val repository: UnsplashRepository
) {

    suspend operator fun invoke(): Result<List<Photo>> {
        return try {
            Result.Success(repository.getPhotos())
        } catch (e: Exception) {
            Result.Error(e.message ?: "Something wrong happened. Please try again.")
        }
    }
}