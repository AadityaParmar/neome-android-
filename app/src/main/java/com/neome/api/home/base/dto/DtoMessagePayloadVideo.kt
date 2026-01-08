// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.home.base.dto.DtoMessagePayloadText
import com.neome.api.meta.base.Types.MediaIdImage
import com.neome.api.meta.base.Types.MediaIdVideo

interface DtoMessagePayloadVideo : DtoMessagePayloadText
{
  val durationMs: Long?
  val fileName: String
  val fileSize: Long?
  val height: Long?
  val mediaId: MediaIdImage
  val mediaIdBlurImage: MediaIdImage
  val mediaIdVideo: MediaIdVideo
  val primaryColor: String
  val width: Long?
}