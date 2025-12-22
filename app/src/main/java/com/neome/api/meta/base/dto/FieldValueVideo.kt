// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MediaIdImage
import com.neome.api.meta.base.Types.MediaIdVideo

class FieldValueVideo {
    val durationMs: number
    var fileName: string? = null
    val mediaIdBlurImage: MediaIdImage
    val mediaIdImage: MediaIdImage
    val mediaIdVideo: MediaIdVideo
    val primaryColor: string
    val size: number
}
