package com.neome.feature.media_carousel.domain.model

data class CarouselConfiguration(
    val cropperEnabled: Boolean = false,
    val showPageIndicator: Boolean = true,
    val autoPlayVideo: Boolean = false,
    val showVideoControls: Boolean = true,
    val enableFullScreen: Boolean = true
)
