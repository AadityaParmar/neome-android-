// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.FieldDtoImage
import com.neome.api.meta.base.dto.StudioBase

open class StudioDtoPlaceHolder : StudioBase()
{
  var image: FieldDtoImage? = null
  var primaryText: String? = null
  var secondaryText: String? = null
}