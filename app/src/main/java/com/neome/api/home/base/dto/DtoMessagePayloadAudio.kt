// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.home.base.dto.DtoMessagePayloadText
import com.neome.api.meta.base.Types.MediaIdAudio

interface DtoMessagePayloadAudio : DtoMessagePayloadText
{
  val durationMs: Long?
  val fileSize: Long?
  val mediaIdAudio: MediaIdAudio
}