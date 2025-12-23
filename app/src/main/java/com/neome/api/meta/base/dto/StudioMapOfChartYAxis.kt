// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdChartYAxis
import java.util.Map

open class StudioMapOfChartYAxis : StudioBase() {
    lateinit var keys: Array<MetaIdChartYAxis>
    lateinit var map: Map<MetaIdChartYAxis, StudioDtoChartYAxis>
}
