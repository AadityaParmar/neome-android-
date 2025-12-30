package com.neome.feature.media_carousel.presentation

import com.neome.feature.media_carousel.domain.model.MediaItem

sealed interface MediaCarouselEvent {
    data class PageChanged(val index: Int) : MediaCarouselEvent
    data object ToggleFullScreen : MediaCarouselEvent
    data class RequestCrop(val index: Int) : MediaCarouselEvent
    data class UpdateItem(val index: Int, val item: MediaItem) : MediaCarouselEvent
    data class RemoveItem(val index: Int) : MediaCarouselEvent
    data object Close : MediaCarouselEvent
    data object ClearError : MediaCarouselEvent
}
