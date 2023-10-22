package com.mahmoudhamdyae.unsplash.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mahmoudhamdyae.unsplash.domain.usecase.GetPhotosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.mahmoudhamdyae.unsplash.util.Result

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPhotosUseCase: GetPhotosUseCase
): ViewModel() {

    var uiState by mutableStateOf(HomeUiState())
        private set

    init {
        getPhotos()
    }

    fun getPhotos() {
        viewModelScope.launch {
            uiState = uiState.copy(
                isLoading = true,
                error = null,
            )
            when (val response = getPhotosUseCase()) {
                is Result.Success -> {
                    uiState = uiState.copy(
                        photos = response.data,
                        isLoading = false,
                        error = null
                    )
                }
                is Result.Error -> {
                    uiState = uiState.copy(
                        photos = listOf(),
                        isLoading = false,
                        error = response.message
                    )
                }
            }
        }
    }
}