package com.neome.feature.filepick.domain.model

enum class FilePickerMode(val mimeType: String) {
    IMAGE("image/*"),
    VIDEO("video/*"),
    IMAGE_VIDEO("image/*,video/*"),
    PDF("application/pdf"),
    ALL("*/*")
}
