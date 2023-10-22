package com.mahmoudhamdyae.unsplash.domain.model

import android.content.Context
import com.google.gson.annotations.SerializedName
import com.mahmoudhamdyae.unsplash.util.Constants.getPhotoUrl

data class Photo(
    val id: Int,
    val filename: String,
    val width: Int,
    val height: Int,
    val format: String,
    val author: String,
    @SerializedName("author_url")
    val authorUrl: String,
    @SerializedName("post_url")
    val postUrl: String
) {
    fun getPhotoUrl(context: Context): String = "${context.getPhotoUrl()}$id"
}