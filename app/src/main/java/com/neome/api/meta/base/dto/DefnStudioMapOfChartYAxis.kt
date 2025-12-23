// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoChartYAxis
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdChartYAxis

open class DefnStudioMapOfChartYAxis
{
  lateinit var keys: Array<MetaIdChartYAxis>
  lateinit var map: Map<MetaIdChartYAxis, DefnDtoChartYAxis>
}