// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.home.base.dto.DtoMessageReplyPayload
import com.neome.api.meta.base.Types.MediaIdImage

interface DtoMessageReplyPayloadCamera : DtoMessageReplyPayload
{
  val mediaIdImage: MediaIdImage
}