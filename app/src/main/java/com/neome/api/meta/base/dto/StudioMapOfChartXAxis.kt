// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdChartXAxis

interface StudioMapOfChartXAxis : StudioBase {
    val keys: List<MetaIdChartXAxis>
    val map: Map<MetaIdChartXAxis, StudioDtoChartXAxis>
}
