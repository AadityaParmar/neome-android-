// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import kotlin.properties.Delegates
import com.neome.api.home.base.dto.DtoMessageReplyPayload
import com.neome.api.meta.base.Types.MediaIdImage
import com.neome.api.meta.base.Types.MediaIdVideo

open class DtoMessageReplyPayloadVideo : DtoMessageReplyPayload()
{
  var durationMs: Number by Delegates.notNull<Number>()
  lateinit var mediaId: MediaIdImage
  lateinit var mediaIdBlurImage: MediaIdImage
  lateinit var mediaIdVideo: MediaIdVideo
  lateinit var primaryColor: String
}