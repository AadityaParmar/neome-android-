package com.neome.feature.media_carousel.presentation

import com.neome.feature.media_carousel.domain.model.MediaItem

sealed interface MediaCarouselEffect {
    data class NavigateToCropper(
        val imageItem: MediaItem.ImageItem,
        val index: Int
    ) : MediaCarouselEffect

    data object NavigateBack : MediaCarouselEffect

    data class ShowError(val message: String) : MediaCarouselEffect
}
