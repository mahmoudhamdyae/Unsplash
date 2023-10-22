package com.mahmoudhamdyae.unsplash.di

import com.mahmoudhamdyae.unsplash.domain.repository.UnsplashRepository
import com.mahmoudhamdyae.unsplash.domain.usecase.GetPhotosUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideUserUseCase(repository: UnsplashRepository): GetPhotosUseCase {
        return GetPhotosUseCase(repository)
    }
}