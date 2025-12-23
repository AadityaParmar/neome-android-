// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import kotlin.properties.Delegates
import com.neome.api.meta.base.Types.MediaIdImage

open class FieldDtoImage
{
  lateinit var fileName: String
  var height: Number by Delegates.notNull<Number>()
  lateinit var mediaIdBlurImage: MediaIdImage
  lateinit var mediaIdImage: MediaIdImage
  lateinit var primaryColor: String
  var size: Number by Delegates.notNull<Number>()
  var width: Number by Delegates.notNull<Number>()
}