// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.meta.base.Types.MediaIdAudio

class DtoMessagePayloadAudio : DtoMessagePayloadText() {
    val durationMs: number
    val fileSize: number
    val mediaIdAudio: MediaIdAudio
}
