package com.mahmoudhamdyae.unsplash.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mahmoudhamdyae.unsplash.domain.usecase.GetPhotosUseCase
import com.mahmoudhamdyae.unsplash.ui.home.mvi.HomeIntent
import com.mahmoudhamdyae.unsplash.ui.home.mvi.HomeViewState
import com.mahmoudhamdyae.unsplash.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPhotosUseCase: GetPhotosUseCase
): ViewModel() {

    val intentChannel = Channel<HomeIntent>(Channel.UNLIMITED)

    private val _viewState = MutableStateFlow(HomeViewState())
    val viewState = _viewState.asStateFlow()

    init {
        viewModelScope.launch { processIntent() }
    }

    private suspend fun processIntent() {
        intentChannel.consumeAsFlow().collect {
            when(it) {
                HomeIntent.GetPhotos -> { reduceResult() }
            }
        }
    }

    private suspend fun reduceResult() {
        _viewState.value = _viewState.value.copy(
            isLoading = true,
            error = null
        )
        when (val response = getPhotosUseCase()) {
            is Result.Success -> {
                _viewState.value = _viewState.value.copy(
                    photos = response.data,
                    isLoading = false
                )
            }
            is Result.Error -> {
                _viewState.value = _viewState.value.copy(
                    isLoading = false,
                    error = response.message
                )
            }
        }
    }
}