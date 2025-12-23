// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.meta.base.Types.MediaIdImage
import com.neome.api.meta.base.Types.MediaIdVideo
import kotlin.properties.Delegates

open class DtoMessageReplyPayloadVideo : DtoMessageReplyPayload() {
    var durationMs: Number by Delegates.notNull<Number>()
    lateinit var mediaId: MediaIdImage
    lateinit var mediaIdBlurImage: MediaIdImage
    lateinit var mediaIdVideo: MediaIdVideo
    lateinit var primaryColor: String
}
