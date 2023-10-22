package com.mahmoudhamdyae.unsplash.util

import android.content.Context

object Constants {

    const val BASE_URL = "https://unsplash.it/"

    fun Context.getPhotoUrl() = "$BASE_URL${this.resources.displayMetrics.widthPixels}?image="
}