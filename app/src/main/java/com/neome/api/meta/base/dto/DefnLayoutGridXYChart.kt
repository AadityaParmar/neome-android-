// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField

class DefnLayoutGridXYChart : DefnLayoutGrid() {
    var hideLegend: boolean? = null
    val xAxis: MetaIdField
    var xAxisMap: DefnStudioMapOfChartXAxis? = null
    var yAxisMap: DefnStudioMapOfChartYAxis? = null
}
