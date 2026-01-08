// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.Point
import com.neome.api.meta.base.dto.Size
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoColor
import com.neome.api.meta.base.Symbol

interface EntVdRect : StudioBase
{
  val bgClr: StudioDtoColor?
  val borderClr: StudioDtoColor?
  val fgClr: StudioDtoColor?
  val label: String?
  val name: Symbol?
  val point: Point?
  val size: Size?
  val textClr: StudioDtoColor?
}