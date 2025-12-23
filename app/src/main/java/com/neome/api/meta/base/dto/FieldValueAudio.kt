// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MediaIdAudio
import kotlin.properties.Delegates

open class FieldValueAudio {
    var durationMs: Number by Delegates.notNull<Number>()
    lateinit var fileName: String
    var fileSize: Number by Delegates.notNull<Number>()
    lateinit var mediaIdAudio: MediaIdAudio
}
