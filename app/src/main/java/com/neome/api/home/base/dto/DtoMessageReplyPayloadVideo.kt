// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.meta.base.Types.MediaIdImage
import com.neome.api.meta.base.Types.MediaIdVideo

class DtoMessageReplyPayloadVideo : DtoMessageReplyPayload() {
    val durationMs: number
    val mediaId: MediaIdImage
    val mediaIdBlurImage: MediaIdImage
    val mediaIdVideo: MediaIdVideo
    val primaryColor: string
}
