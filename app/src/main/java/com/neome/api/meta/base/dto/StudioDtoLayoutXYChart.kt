// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.dto.StudioDtoLayoutGrid
import com.neome.api.meta.base.dto.StudioMapOfChartXAxis
import com.neome.api.meta.base.dto.StudioMapOfChartYAxis

interface StudioDtoLayoutXYChart : StudioDtoLayoutGrid
{
  val hideLegend: Boolean?
  val xAxis: MetaIdField?
  val xAxisMap: StudioMapOfChartXAxis?
  val yAxisMap: StudioMapOfChartYAxis?
}