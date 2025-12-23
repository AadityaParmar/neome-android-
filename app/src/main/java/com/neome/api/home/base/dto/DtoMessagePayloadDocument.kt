// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import kotlin.properties.Delegates
import com.neome.api.home.base.dto.DtoMessagePayload
import com.neome.api.meta.base.Types.MediaIdDocument

open class DtoMessagePayloadDocument : DtoMessagePayload()
{
  lateinit var fileExt: String
  lateinit var fileName: String
  var fileSize: Number by Delegates.notNull<Number>()
  lateinit var mediaIdDocument: MediaIdDocument
}