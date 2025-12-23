// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField

open class StudioDtoLayoutXYChart : StudioDtoLayoutGrid() {
    var hideLegend: Boolean? = null
    var xAxis: MetaIdField? = null
    var xAxisMap: StudioMapOfChartXAxis? = null
    var yAxisMap: StudioMapOfChartYAxis? = null
}
