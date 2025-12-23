// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import kotlin.properties.Delegates
import com.neome.api.meta.base.Types.EnumDefnDocFileExt
import com.neome.api.meta.base.Types.MediaIdDocument

open class FieldDtoDocument
{
  lateinit var fileExt: EnumDefnDocFileExt
  lateinit var fileName: String
  var fileSize: Number by Delegates.notNull<Number>()
  lateinit var mediaIdDocument: MediaIdDocument
}