// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdChartYAxis

class StudioMapOfChartYAxis : StudioBase() {
    val keys: MetaIdChartYAxis[]
    val map: Record<MetaIdChartYAxis, StudioDtoChartYAxis>
}
