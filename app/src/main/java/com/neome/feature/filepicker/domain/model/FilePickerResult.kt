package com.neome.feature.filepicker.domain.model

import android.net.Uri

data class FilePickerResult(
    val fileName: String,
    val fileSize: Long,
    val mimeType: String,
    val uri: Uri
)
