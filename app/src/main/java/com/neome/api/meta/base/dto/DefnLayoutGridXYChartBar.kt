// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnLayoutGridXYChart
import com.neome.api.meta.base.Types.EnumDefnChartRenderingMode

interface DefnLayoutGridXYChartBar : DefnLayoutGridXYChart
{
  val alwaysShowBarValues: Boolean?
  val renderingMode: EnumDefnChartRenderingMode?
}