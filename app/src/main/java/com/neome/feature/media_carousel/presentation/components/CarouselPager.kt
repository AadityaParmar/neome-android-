package com.neome.feature.media_carousel.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.neome.feature.media_carousel.domain.model.CarouselConfiguration
import com.neome.feature.media_carousel.domain.model.MediaItem

@Composable
fun CarouselPager(
    items: List<MediaItem>,
    pagerState: PagerState,
    configuration: CarouselConfiguration,
    modifier: Modifier = Modifier,
    isFullScreen: Boolean = false,
    onCropClick: (Int) -> Unit = {}
) {
    HorizontalPager(
        state = pagerState,
        modifier = modifier.fillMaxSize(),
        beyondViewportPageCount = 1
    ) { page ->
        val item = items.getOrNull(page)
        val isCurrentPage = pagerState.currentPage == page

        Box(modifier = Modifier.fillMaxSize()) {
            when (item) {
                is MediaItem.ImageItem -> {
                    ImagePreview(
                        imageItem = item,
                        modifier = Modifier.fillMaxSize(),
                        cropperEnabled = configuration.cropperEnabled,
                        isFullScreen = isFullScreen,
                        onCropClick = { onCropClick(page) }
                    )
                }

                is MediaItem.VideoItem -> {
                    VideoPreview(
                        videoItem = item,
                        modifier = Modifier.fillMaxSize(),
                        isCurrentPage = isCurrentPage,
                        showControls = configuration.showVideoControls,
                        autoPlay = configuration.autoPlayVideo && isCurrentPage
                    )
                }

                is MediaItem.FileItem -> {
                    FilePreview(
                        fileItem = item,
                        modifier = Modifier.fillMaxSize()
                    )
                }

                null -> {
                    // Empty state handled by parent
                }
            }
        }
    }
}
