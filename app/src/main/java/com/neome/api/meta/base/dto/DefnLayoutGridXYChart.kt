// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnLayoutGrid
import com.neome.api.meta.base.dto.DefnStudioMapOfChartXAxis
import com.neome.api.meta.base.dto.DefnStudioMapOfChartYAxis
import com.neome.api.meta.base.Types.MetaIdField

open class DefnLayoutGridXYChart : DefnLayoutGrid()
{
  var hideLegend: Boolean? = null
  lateinit var xAxis: MetaIdField
  var xAxisMap: DefnStudioMapOfChartXAxis? = null
  var yAxisMap: DefnStudioMapOfChartYAxis? = null
}