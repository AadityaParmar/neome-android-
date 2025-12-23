// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import kotlin.properties.Delegates
import com.neome.api.home.base.dto.DtoMessagePayloadText
import com.neome.api.meta.base.Types.MediaIdImage

open class DtoMessagePayloadImage : DtoMessagePayloadText()
{
  var fileSize: Number by Delegates.notNull<Number>()
  var height: Number by Delegates.notNull<Number>()
  lateinit var mediaIdBlurImage: MediaIdImage
  lateinit var mediaIdImage: MediaIdImage
  lateinit var primaryColor: String
  var width: Number by Delegates.notNull<Number>()
}