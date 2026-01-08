// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoChartXAxis
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdChartXAxis

interface DefnStudioMapOfChartXAxis
{
  val keys: Array<MetaIdChartXAxis>
  val map: Map<MetaIdChartXAxis, DefnDtoChartXAxis>
}