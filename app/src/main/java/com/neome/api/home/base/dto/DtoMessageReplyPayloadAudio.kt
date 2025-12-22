// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.meta.base.Types.MediaIdAudio

class DtoMessageReplyPayloadAudio : DtoMessageReplyPayload() {
    val durationMs: number
    val mediaIdAudio: MediaIdAudio
}
