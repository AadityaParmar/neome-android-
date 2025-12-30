package com.neome.feature.media_carousel.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.neome.feature.media_carousel.domain.model.CarouselConfiguration
import com.neome.feature.media_carousel.domain.model.MediaItem
import com.neome.feature.media_carousel.presentation.components.CarouselPager
import com.neome.feature.media_carousel.presentation.components.PageIndicator
import kotlinx.coroutines.flow.distinctUntilChanged

@Composable
fun MediaCarousel(
    items: List<MediaItem>,
    modifier: Modifier = Modifier,
    configuration: CarouselConfiguration = CarouselConfiguration(),
    initialIndex: Int = 0,
    onCropRequest: ((MediaItem.ImageItem, Int) -> Unit)? = null,
    onPageChanged: ((Int) -> Unit)? = null,
    viewModel: MediaCarouselViewModel = viewModel()
) {
    // Initialize ViewModel
    LaunchedEffect(items, configuration, initialIndex) {
        viewModel.initialize(items, configuration, initialIndex)
    }

    val state by viewModel.state.collectAsStateWithLifecycle()

    // Collect effects
    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is MediaCarouselEffect.NavigateToCropper -> {
                    onCropRequest?.invoke(effect.imageItem, effect.index)
                }
                is MediaCarouselEffect.NavigateBack -> {
                    // Handle in parent
                }
                is MediaCarouselEffect.ShowError -> {
                    // Handle error display
                }
            }
        }
    }

    MediaCarouselContent(
        state = state,
        onEvent = viewModel::onEvent,
        modifier = modifier
    )
}

@Composable
fun MediaCarouselContent(
    state: MediaCarouselState,
    onEvent: (MediaCarouselEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    if (!state.hasItems) {
        EmptyCarousel(modifier = modifier)
        return
    }

    val pagerState = rememberPagerState(
        initialPage = state.currentIndex,
        pageCount = { state.itemCount }
    )

    // Sync pager state with ViewModel state
    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }
            .distinctUntilChanged()
            .collect { page ->
                onEvent(MediaCarouselEvent.PageChanged(page))
            }
    }

    // Sync ViewModel state with pager
    LaunchedEffect(state.currentIndex) {
        if (pagerState.currentPage != state.currentIndex) {
            pagerState.animateScrollToPage(state.currentIndex)
        }
    }

    Column(modifier = modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            CarouselPager(
                items = state.items,
                pagerState = pagerState,
                configuration = state.configuration,
                modifier = Modifier.fillMaxSize(),
                isFullScreen = state.isFullScreen,
                onCropClick = { index ->
                    onEvent(MediaCarouselEvent.RequestCrop(index))
                }
            )
        }

        // Page indicator
        if (state.configuration.showPageIndicator && state.itemCount > 1) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                contentAlignment = Alignment.Center
            ) {
                PageIndicator(
                    pageCount = state.itemCount,
                    currentPage = pagerState.currentPage
                )
            }
        }
    }
}

@Composable
private fun EmptyCarousel(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surfaceVariant),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "No media to display",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
fun StatelessMediaCarousel(
    items: List<MediaItem>,
    currentIndex: Int,
    configuration: CarouselConfiguration,
    modifier: Modifier = Modifier,
    isFullScreen: Boolean = false,
    onPageChanged: (Int) -> Unit = {},
    onCropClick: (Int) -> Unit = {}
) {
    if (items.isEmpty()) {
        EmptyCarousel(modifier = modifier)
        return
    }

    val pagerState = rememberPagerState(
        initialPage = currentIndex.coerceIn(0, items.size - 1),
        pageCount = { items.size }
    )

    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }
            .distinctUntilChanged()
            .collect { page ->
                onPageChanged(page)
            }
    }

    LaunchedEffect(currentIndex) {
        if (pagerState.currentPage != currentIndex && currentIndex in items.indices) {
            pagerState.animateScrollToPage(currentIndex)
        }
    }

    Column(modifier = modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            CarouselPager(
                items = items,
                pagerState = pagerState,
                configuration = configuration,
                modifier = Modifier.fillMaxSize(),
                isFullScreen = isFullScreen,
                onCropClick = onCropClick
            )
        }

        if (configuration.showPageIndicator && items.size > 1) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                contentAlignment = Alignment.Center
            ) {
                PageIndicator(
                    pageCount = items.size,
                    currentPage = pagerState.currentPage
                )
            }
        }
    }
}
