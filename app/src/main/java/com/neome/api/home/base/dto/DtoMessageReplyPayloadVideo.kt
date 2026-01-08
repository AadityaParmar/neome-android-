// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.home.base.dto.DtoMessageReplyPayload
import com.neome.api.meta.base.Types.MediaIdImage
import com.neome.api.meta.base.Types.MediaIdVideo

interface DtoMessageReplyPayloadVideo : DtoMessageReplyPayload
{
  val durationMs: Long?
  val mediaId: MediaIdImage
  val mediaIdBlurImage: MediaIdImage
  val mediaIdVideo: MediaIdVideo
  val primaryColor: String
}