package com.neome.feature.componentshowcase.presentation.components

import android.graphics.BitmapFactory
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.VideoLibrary
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.aventrix.jnanoid.jnanoid.NanoIdUtils
import com.neome.feature.cropper.domain.model.CroppableImage
import com.neome.feature.cropper.presentation.ImageCropScreen
import com.neome.feature.filepicker.domain.model.FilePickerMode
import com.neome.feature.filepicker.domain.model.FilePickerResult
import com.neome.feature.filepicker.presentation.rememberMultiFilePicker
import com.neome.feature.media_carousel.domain.model.CarouselConfiguration
import com.neome.feature.media_carousel.domain.model.MediaItem
import com.neome.feature.media_carousel.presentation.StatelessMediaCarousel
import com.neome.feature.utils.VideoThumbnailExtractor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun MediaCarouselShowcase() {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    val mediaItems = remember { mutableStateListOf<MediaItem>() }
    var currentIndex by remember { mutableIntStateOf(0) }
    var cropperEnabled by remember { mutableStateOf(false) }
    var showCropper by remember { mutableStateOf(false) }
    var itemToCrop by remember { mutableStateOf<Pair<MediaItem.ImageItem, Int>?>(null) }

    val pickImages = rememberMultiFilePicker(mode = FilePickerMode.IMAGE) { results ->
        if (results.isNotEmpty()) {
            scope.launch {
                val newItems = results.mapNotNull { fileResult ->
                    createImageItem(context, fileResult)
                }
                mediaItems.addAll(newItems)
            }
        }
    }

    val pickVideos = rememberMultiFilePicker(mode = FilePickerMode.VIDEO) { results ->
        if (results.isNotEmpty()) {
            scope.launch {
                val newItems = results.mapNotNull { fileResult ->
                    createVideoItem(context, fileResult)
                }
                mediaItems.addAll(newItems)
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Media Carousel",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "Horizontally swipeable preview for images and videos with playback controls",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Controls Card
        ElevatedCard(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.elevatedCardElevation(defaultElevation = 2.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Add Media",
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(
                        onClick = pickImages,
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(Icons.Default.Image, contentDescription = null)
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Images")
                    }

                    Button(
                        onClick = pickVideos,
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(Icons.Default.VideoLibrary, contentDescription = null)
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Videos")
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Cropper toggle
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Enable Cropping",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Switch(
                        checked = cropperEnabled,
                        onCheckedChange = { cropperEnabled = it }
                    )
                }

                if (mediaItems.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(12.dp))

                    OutlinedButton(
                        onClick = {
                            mediaItems.clear()
                            currentIndex = 0
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(Icons.Default.Clear, contentDescription = null)
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Clear All")
                    }
                }
            }
        }

        // Carousel Preview Card
        if (mediaItems.isNotEmpty()) {
            ElevatedCard(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.elevatedCardElevation(defaultElevation = 2.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Preview (${mediaItems.size} items)",
                            style = MaterialTheme.typography.titleMedium
                        )

                        Text(
                            text = "${currentIndex + 1} / ${mediaItems.size}",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    StatelessMediaCarousel(
                        items = mediaItems.toList(),
                        currentIndex = currentIndex,
                        configuration = CarouselConfiguration(
                            cropperEnabled = cropperEnabled,
                            showPageIndicator = true,
                            showVideoControls = true,
                            autoPlayVideo = false
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp),
                        onPageChanged = { index ->
                            currentIndex = index
                        },
                        onCropClick = { index ->
                            val item = mediaItems.getOrNull(index)
                            if (item is MediaItem.ImageItem) {
                                itemToCrop = item to index
                                showCropper = true
                            }
                        }
                    )
                }
            }
        } else {
            // Empty state
            ElevatedCard(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.elevatedCardElevation(defaultElevation = 2.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Add images or videos to see the carousel",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }

        // Cropper Dialog
        if (showCropper && itemToCrop != null) {
            val (imageItem, index) = itemToCrop!!

            // Convert to CroppableImage
            val croppableImage = remember(imageItem.id) {
                imageItem.bytes?.let { bytes ->
                    CroppableImage(
                        bytes = bytes,
                        width = imageItem.width,
                        height = imageItem.height,
                        mimeType = imageItem.mimeType
                    )
                }
            }

            if (croppableImage != null) {
                androidx.compose.ui.window.Dialog(
                    onDismissRequest = {
                        showCropper = false
                        itemToCrop = null
                    },
                    properties = androidx.compose.ui.window.DialogProperties(
                        usePlatformDefaultWidth = false
                    )
                ) {
                    ImageCropScreen(
                        sourceImage = croppableImage,
                        onCropConfirmed = { croppedImage ->
                            // Update the item with cropped image
                            val bitmap = BitmapFactory.decodeByteArray(
                                croppedImage.bytes,
                                0,
                                croppedImage.bytes.size
                            )
                            val updatedItem = imageItem.copy(
                                bytes = croppedImage.bytes,
                                bitmap = bitmap,
                                width = croppedImage.width,
                                height = croppedImage.height
                            )
                            mediaItems[index] = updatedItem
                            showCropper = false
                            itemToCrop = null
                        },
                        onCancelled = {
                            showCropper = false
                            itemToCrop = null
                        },
                        onError = {
                            showCropper = false
                            itemToCrop = null
                        }
                    )
                }
            }
        }
    }
}

private suspend fun createImageItem(
    context: android.content.Context,
    result: FilePickerResult
): MediaItem.ImageItem? = withContext(Dispatchers.IO) {
    try {
        val bytes = context.contentResolver.openInputStream(result.uri)?.use { stream ->
            stream.readBytes()
        } ?: return@withContext null

        val bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
            ?: return@withContext null

        MediaItem.ImageItem(
            id = NanoIdUtils.randomNanoId(),
            uri = result.uri,
            mimeType = result.mimeType,
            bytes = bytes,
            bitmap = bitmap,
            width = bitmap.width,
            height = bitmap.height
        )
    } catch (e: Exception) {
        null
    }
}

private suspend fun createVideoItem(
    context: android.content.Context,
    result: FilePickerResult
): MediaItem.VideoItem? = withContext(Dispatchers.IO) {
    try {
        val thumbnailOutcome = VideoThumbnailExtractor.extractThumbnail(
            context.contentResolver,
            result.uri
        )

        val (thumbnail, duration) = when (thumbnailOutcome) {
            is com.neome.feature.utils.ThumbnailOutcome.Success -> {
                thumbnailOutcome.result.bitmap to (thumbnailOutcome.result.videoDurationMs ?: 0L)
            }
            is com.neome.feature.utils.ThumbnailOutcome.Error -> {
                null to 0L
            }
        }

        MediaItem.VideoItem(
            id = NanoIdUtils.randomNanoId(),
            uri = result.uri,
            mimeType = result.mimeType,
            thumbnailBitmap = thumbnail,
            durationMs = duration,
            fileName = result.fileName
        )
    } catch (e: Exception) {
        null
    }
}
