// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnThemeColor
import com.neome.api.meta.base.Types.EnumDefnThemeColorShade
import com.neome.api.meta.base.dto.StudioBase

interface StudioDtoColor : StudioBase
{
  val shade: EnumDefnThemeColorShade?
  val value: EnumDefnThemeColor?
}