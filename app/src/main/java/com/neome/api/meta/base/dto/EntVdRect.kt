// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.Point
import com.neome.api.meta.base.dto.Size
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoColor

open class EntVdRect : StudioBase()
{
  var bgClr: StudioDtoColor? = null
  var borderClr: StudioDtoColor? = null
  var fgClr: StudioDtoColor? = null
  var point: Point? = null
  var size: Size? = null
  var textClr: StudioDtoColor? = null
}