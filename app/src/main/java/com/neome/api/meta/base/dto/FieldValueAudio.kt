// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MediaIdAudio

class FieldValueAudio {
    val durationMs: number
    val fileName: string
    val fileSize: number
    val mediaIdAudio: MediaIdAudio
}
