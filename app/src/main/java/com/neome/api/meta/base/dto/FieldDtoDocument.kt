// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnDocFileExt
import com.neome.api.meta.base.Types.MediaIdDocument

interface FieldDtoDocument
{
  val fileExt: EnumDefnDocFileExt
  val fileName: String
  val fileSize: Long?
  val mediaIdDocument: MediaIdDocument
}