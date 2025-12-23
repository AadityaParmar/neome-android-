// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnKindImageXform
import com.neome.api.meta.base.dto.StudioBase

open class ImageXform : StudioBase()
{
  var kind: EnumDefnKindImageXform? = null
}