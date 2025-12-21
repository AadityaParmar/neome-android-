package com.neome.feature.camera.domain.model

/**
 * Result of a successful image save operation.
 */
data class SavedImageResult(
    val uri: String,
    val fileName: String,
    val filePath: String,
    val sizeBytes: Long,
    val timestamp: Long = System.currentTimeMillis()
)
