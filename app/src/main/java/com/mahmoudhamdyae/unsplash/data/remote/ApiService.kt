package com.mahmoudhamdyae.unsplash.data.remote

import com.mahmoudhamdyae.unsplash.domain.model.Photos
import retrofit2.http.GET

interface ApiService {

    @GET("list")
    suspend fun getPhotos(): Photos
}