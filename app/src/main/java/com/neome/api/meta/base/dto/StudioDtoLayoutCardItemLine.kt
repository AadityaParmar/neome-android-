// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoLayoutCardItemLineSegment

open class StudioDtoLayoutCardItemLine : StudioBase()
{
  var caption: StudioDtoLayoutCardItemLineSegment? = null
  var first: StudioDtoLayoutCardItemLineSegment? = null
  var middle: StudioDtoLayoutCardItemLineSegment? = null
}