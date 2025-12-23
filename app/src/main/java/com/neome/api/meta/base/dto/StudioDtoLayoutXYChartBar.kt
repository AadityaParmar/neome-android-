// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnChartRenderingMode
import com.neome.api.meta.base.dto.StudioDtoLayoutXYChart

open class StudioDtoLayoutXYChartBar : StudioDtoLayoutXYChart()
{
  var alwaysShowBarValues: Boolean? = null
  var renderingMode: EnumDefnChartRenderingMode? = null
}