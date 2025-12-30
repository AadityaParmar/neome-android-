package com.neome.feature.media_carousel.presentation

import com.neome.feature.media_carousel.domain.model.CarouselConfiguration
import com.neome.feature.media_carousel.domain.model.MediaItem

data class MediaCarouselState(
    val items: List<MediaItem> = emptyList(),
    val currentIndex: Int = 0,
    val isFullScreen: Boolean = false,
    val isLoading: Boolean = false,
    val error: String? = null,
    val configuration: CarouselConfiguration = CarouselConfiguration()
) {
    val currentItem: MediaItem?
        get() = items.getOrNull(currentIndex)

    val hasItems: Boolean
        get() = items.isNotEmpty()

    val itemCount: Int
        get() = items.size
}
