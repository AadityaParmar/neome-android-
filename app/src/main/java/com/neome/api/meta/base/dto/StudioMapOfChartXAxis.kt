// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdChartXAxis
import java.util.Map

open class StudioMapOfChartXAxis : StudioBase() {
    lateinit var keys: Array<MetaIdChartXAxis>
    lateinit var map: Map<MetaIdChartXAxis, StudioDtoChartXAxis>
}
