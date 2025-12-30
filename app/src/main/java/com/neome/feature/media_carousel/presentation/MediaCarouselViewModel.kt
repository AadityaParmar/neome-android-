package com.neome.feature.media_carousel.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.neome.feature.media_carousel.domain.model.CarouselConfiguration
import com.neome.feature.media_carousel.domain.model.MediaItem
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MediaCarouselViewModel : ViewModel() {

    private val _state = MutableStateFlow(MediaCarouselState())
    val state = _state.asStateFlow()

    private val _effect = Channel<MediaCarouselEffect>()
    val effect = _effect.receiveAsFlow()

    fun initialize(
        items: List<MediaItem>,
        configuration: CarouselConfiguration = CarouselConfiguration(),
        initialIndex: Int = 0
    ) {
        _state.update {
            it.copy(
                items = items,
                configuration = configuration,
                currentIndex = initialIndex.coerceIn(0, (items.size - 1).coerceAtLeast(0))
            )
        }
    }

    fun onEvent(event: MediaCarouselEvent) {
        when (event) {
            is MediaCarouselEvent.PageChanged -> updateCurrentIndex(event.index)
            is MediaCarouselEvent.ToggleFullScreen -> toggleFullScreen()
            is MediaCarouselEvent.RequestCrop -> requestCrop(event.index)
            is MediaCarouselEvent.UpdateItem -> updateItem(event.index, event.item)
            is MediaCarouselEvent.RemoveItem -> removeItem(event.index)
            is MediaCarouselEvent.Close -> close()
            is MediaCarouselEvent.ClearError -> clearError()
        }
    }

    private fun updateCurrentIndex(index: Int) {
        val items = _state.value.items
        if (index in items.indices) {
            _state.update { it.copy(currentIndex = index) }
        }
    }

    private fun toggleFullScreen() {
        _state.update { it.copy(isFullScreen = !it.isFullScreen) }
    }

    private fun requestCrop(index: Int) {
        val items = _state.value.items
        val item = items.getOrNull(index)

        if (item is MediaItem.ImageItem) {
            viewModelScope.launch {
                _effect.send(MediaCarouselEffect.NavigateToCropper(item, index))
            }
        } else {
            viewModelScope.launch {
                _effect.send(MediaCarouselEffect.ShowError("Only images can be cropped"))
            }
        }
    }

    private fun updateItem(index: Int, item: MediaItem) {
        val items = _state.value.items.toMutableList()
        if (index in items.indices) {
            items[index] = item
            _state.update { it.copy(items = items) }
        }
    }

    private fun removeItem(index: Int) {
        val items = _state.value.items.toMutableList()
        if (index in items.indices) {
            items.removeAt(index)
            val newIndex = when {
                items.isEmpty() -> 0
                index >= items.size -> items.size - 1
                else -> index
            }
            _state.update {
                it.copy(
                    items = items,
                    currentIndex = newIndex
                )
            }
        }
    }

    private fun close() {
        viewModelScope.launch {
            _effect.send(MediaCarouselEffect.NavigateBack)
        }
    }

    private fun clearError() {
        _state.update { it.copy(error = null) }
    }

    fun updateItems(items: List<MediaItem>) {
        _state.update {
            it.copy(
                items = items,
                currentIndex = it.currentIndex.coerceIn(0, (items.size - 1).coerceAtLeast(0))
            )
        }
    }

    fun updateConfiguration(configuration: CarouselConfiguration) {
        _state.update { it.copy(configuration = configuration) }
    }
}
