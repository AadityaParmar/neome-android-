// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.home.base.dto.DtoMessagePayloadText
import com.neome.api.meta.base.Types.MediaIdImage

interface DtoMessagePayloadLocation : DtoMessagePayloadText
{
  val city: String?
  val country: String?
  val latitude: Long?
  val longitude: Long?
  val mediaIdImage: MediaIdImage
}