// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdChartXAxis
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoChartXAxis

interface StudioMapOfChartXAxis : StudioBase
{
  val keys: Array<MetaIdChartXAxis>
  val map: Map<MetaIdChartXAxis, StudioDtoChartXAxis>
}