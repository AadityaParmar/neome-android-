// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdChartXAxis
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoColor
import com.neome.api.meta.base.Symbol

open class StudioDtoChartXAxis : StudioBase()
{
  var color: StudioDtoColor? = null
  var colorFieldId: MetaIdField? = null
  var colorVarId: MetaIdVar? = null
  var label: String? = null
  lateinit var metaId: MetaIdChartXAxis
  var name: Symbol? = null
  var valueOptionId: String? = null
}