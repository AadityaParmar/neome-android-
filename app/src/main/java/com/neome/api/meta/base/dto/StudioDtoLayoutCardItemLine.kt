// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoLayoutCardItemLineSegment

interface StudioDtoLayoutCardItemLine : StudioBase
{
  val caption: StudioDtoLayoutCardItemLineSegment?
  val first: StudioDtoLayoutCardItemLineSegment?
  val middle: StudioDtoLayoutCardItemLineSegment?
}