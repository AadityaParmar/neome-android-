// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import kotlin.properties.Delegates
import com.neome.api.home.base.dto.DtoMessagePayloadText
import com.neome.api.meta.base.Types.MediaIdAudio

open class DtoMessagePayloadAudio : DtoMessagePayloadText()
{
  var durationMs: Number by Delegates.notNull<Number>()
  var fileSize: Number by Delegates.notNull<Number>()
  lateinit var mediaIdAudio: MediaIdAudio
}