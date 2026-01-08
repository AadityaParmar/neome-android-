// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnLayoutGrid
import com.neome.api.meta.base.dto.DefnStudioMapOfChartXAxis
import com.neome.api.meta.base.dto.DefnStudioMapOfChartYAxis
import com.neome.api.meta.base.Types.MetaIdField

interface DefnLayoutGridXYChart : DefnLayoutGrid
{
  val hideLegend: Boolean?
  val xAxis: MetaIdField
  val xAxisMap: DefnStudioMapOfChartXAxis?
  val yAxisMap: DefnStudioMapOfChartYAxis?
}