// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.home.base.dto.DtoMessagePayloadOptionalText
import com.neome.api.meta.base.Types.MediaIdAudio

interface DtoMessagePayloadAudio : DtoMessagePayloadOptionalText
{
  val durationMs: Long
  val fileSize: Long
  val mediaIdAudio: MediaIdAudio
}