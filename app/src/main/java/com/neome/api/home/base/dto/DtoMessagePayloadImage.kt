// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.home.base.dto.DtoMessagePayloadOptionalText
import com.neome.api.meta.base.Types.MediaIdImage

interface DtoMessagePayloadImage : DtoMessagePayloadOptionalText
{
  val fileSize: Long
  val height: Long
  val mediaIdBlurImage: MediaIdImage
  val mediaIdImage: MediaIdImage
  val primaryColor: String
  val width: Long
}