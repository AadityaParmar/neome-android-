// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.home.base.dto.DtoMessagePayloadOptionalText
import com.neome.api.meta.base.Types.MediaIdDocument

interface DtoMessagePayloadDocument : DtoMessagePayloadOptionalText
{
  val fileExt: String
  val fileName: String
  val fileSize: Long
  val mediaIdDocument: MediaIdDocument
}