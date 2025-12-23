// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MediaIdImage
import com.neome.api.meta.base.Types.MediaIdVideo
import kotlin.properties.Delegates

open class FieldValueVideo {
    var durationMs: Number by Delegates.notNull<Number>()
    var fileName: String? = null
    lateinit var mediaIdBlurImage: MediaIdImage
    lateinit var mediaIdImage: MediaIdImage
    lateinit var mediaIdVideo: MediaIdVideo
    lateinit var primaryColor: String
    var size: Number by Delegates.notNull<Number>()
}
