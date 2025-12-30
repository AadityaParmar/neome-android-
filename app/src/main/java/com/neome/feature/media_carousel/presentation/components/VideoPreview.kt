package com.neome.feature.media_carousel.presentation.components

import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem as ExoMediaItem
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.neome.feature.media_carousel.domain.model.MediaItem
import kotlinx.coroutines.delay

@Composable
fun VideoPreview(
    videoItem: MediaItem.VideoItem,
    modifier: Modifier = Modifier,
    isCurrentPage: Boolean = true,
    showControls: Boolean = true,
    autoPlay: Boolean = false
) {
    val context = LocalContext.current

    var isPlaying by remember { mutableStateOf(false) }
    var isMuted by remember { mutableStateOf(false) }
    var currentPosition by remember { mutableLongStateOf(0L) }
    var duration by remember { mutableLongStateOf(videoItem.durationMs) }
    var isBuffering by remember { mutableStateOf(false) }
    var hasStartedPlaying by remember { mutableStateOf(false) }

    val exoPlayer = remember(videoItem.id) {
        ExoPlayer.Builder(context).build().apply {
            val mediaItem = ExoMediaItem.fromUri(videoItem.uri)
            setMediaItem(mediaItem)
            prepare()
            playWhenReady = autoPlay
        }
    }

    // Update playback state
    LaunchedEffect(exoPlayer) {
        exoPlayer.addListener(object : Player.Listener {
            override fun onIsPlayingChanged(playing: Boolean) {
                isPlaying = playing
                if (playing) hasStartedPlaying = true
            }

            override fun onPlaybackStateChanged(playbackState: Int) {
                isBuffering = playbackState == Player.STATE_BUFFERING
                if (playbackState == Player.STATE_READY) {
                    duration = exoPlayer.duration
                }
            }
        })
    }

    // Update position periodically
    LaunchedEffect(isPlaying) {
        while (isPlaying) {
            currentPosition = exoPlayer.currentPosition
            delay(500)
        }
    }

    // Pause when not current page
    LaunchedEffect(isCurrentPage) {
        if (!isCurrentPage && exoPlayer.isPlaying) {
            exoPlayer.pause()
        }
    }

    // Cleanup
    DisposableEffect(videoItem.id) {
        onDispose {
            exoPlayer.release()
        }
    }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (!hasStartedPlaying && videoItem.thumbnailBitmap != null) {
            // Show thumbnail before playing
            Image(
                bitmap = videoItem.thumbnailBitmap.asImageBitmap(),
                contentDescription = "Video thumbnail",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            // Play button overlay
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .background(
                        MaterialTheme.colorScheme.primary.copy(alpha = 0.9f),
                        CircleShape
                    )
                    .clickable {
                        exoPlayer.play()
                    },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = "Play video",
                    modifier = Modifier.size(40.dp),
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        } else {
            // Video player view
            AndroidView(
                factory = { ctx ->
                    PlayerView(ctx).apply {
                        player = exoPlayer
                        useController = false
                        layoutParams = FrameLayout.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.MATCH_PARENT
                        )
                    }
                },
                modifier = Modifier.fillMaxSize()
            )

            // Buffering indicator
            if (isBuffering) {
                Box(
                    modifier = Modifier
                        .size(64.dp)
                        .background(Color.Black.copy(alpha = 0.5f), CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(40.dp),
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }

            // Controls overlay
            if (showControls && hasStartedPlaying) {
                VideoControls(
                    isPlaying = isPlaying,
                    isMuted = isMuted,
                    currentPositionMs = currentPosition,
                    durationMs = duration,
                    modifier = Modifier.align(Alignment.BottomCenter),
                    onPlayPauseClick = {
                        if (exoPlayer.isPlaying) {
                            exoPlayer.pause()
                        } else {
                            exoPlayer.play()
                        }
                    },
                    onMuteClick = {
                        isMuted = !isMuted
                        exoPlayer.volume = if (isMuted) 0f else 1f
                    },
                    onSeek = { progress ->
                        val seekPosition = (progress * duration).toLong()
                        exoPlayer.seekTo(seekPosition)
                        currentPosition = seekPosition
                    }
                )
            }

            // Tap to play/pause when no controls showing
            if (!showControls || !hasStartedPlaying) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable {
                            if (exoPlayer.isPlaying) {
                                exoPlayer.pause()
                            } else {
                                exoPlayer.play()
                            }
                        }
                )
            }
        }
    }
}
