package com.neome.feature.filepicker.domain.model

enum class FilePickerMode(val mimeType: String) {
    IMAGE("image/*"),
    VIDEO("video/*"),
    IMAGE_VIDEO("image/*,video/*"),
    PDF("application/pdf"),
    ALL("*/*")
}
