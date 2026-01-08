// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdChartYAxis
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoChartYAxis

interface StudioMapOfChartYAxis : StudioBase
{
  val keys: Array<MetaIdChartYAxis>
  val map: Map<MetaIdChartYAxis, StudioDtoChartYAxis>
}