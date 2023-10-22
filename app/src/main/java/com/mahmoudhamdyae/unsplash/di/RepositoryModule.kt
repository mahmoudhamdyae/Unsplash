package com.mahmoudhamdyae.unsplash.di

import com.mahmoudhamdyae.unsplash.data.remote.ApiService
import com.mahmoudhamdyae.unsplash.data.repository.UnsplashRepositoryImp
import com.mahmoudhamdyae.unsplash.domain.repository.UnsplashRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideRepository(apiService: ApiService): UnsplashRepository {
        return UnsplashRepositoryImp(apiService)
    }
}