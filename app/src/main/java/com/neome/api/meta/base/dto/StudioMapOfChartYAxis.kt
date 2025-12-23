// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdChartYAxis
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoChartYAxis

open class StudioMapOfChartYAxis : StudioBase()
{
  lateinit var keys: Array<MetaIdChartYAxis>
  lateinit var map: Map<MetaIdChartYAxis, StudioDtoChartYAxis>
}