// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.meta.base.Types.MediaIdAudio
import kotlin.properties.Delegates

open class DtoMessageReplyPayloadAudio : DtoMessageReplyPayload() {
    var durationMs: Number by Delegates.notNull<Number>()
    lateinit var mediaIdAudio: MediaIdAudio
}
