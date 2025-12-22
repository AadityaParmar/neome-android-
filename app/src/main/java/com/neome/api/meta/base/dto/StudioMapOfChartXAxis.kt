// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdChartXAxis

class StudioMapOfChartXAxis : StudioBase() {
    val keys: MetaIdChartXAxis[]
    val map: Record<MetaIdChartXAxis, StudioDtoChartXAxis>
}
