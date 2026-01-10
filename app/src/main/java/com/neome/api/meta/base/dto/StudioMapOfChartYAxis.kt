// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdChartYAxis

interface StudioMapOfChartYAxis : StudioBase {
    val keys: List<MetaIdChartYAxis>
    val map: Map<MetaIdChartYAxis, StudioDtoChartYAxis>
}
