// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoChartXAxis
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdChartXAxis

open class DefnStudioMapOfChartXAxis
{
  lateinit var keys: Array<MetaIdChartXAxis>
  lateinit var map: Map<MetaIdChartXAxis, DefnDtoChartXAxis>
}