// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdChartXAxis
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoChartXAxis

open class StudioMapOfChartXAxis : StudioBase()
{
  lateinit var keys: Array<MetaIdChartXAxis>
  lateinit var map: Map<MetaIdChartXAxis, StudioDtoChartXAxis>
}