// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoColor
import com.neome.api.meta.base.Types.MetaIdChartXAxis
import com.neome.api.meta.base.Types.MetaIdField

open class DefnDtoChartXAxis
{
  var color: DefnDtoColor? = null
  var colorFieldId: MetaIdField? = null
  var colorVar: DefnDtoColor? = null
  var label: String? = null
  lateinit var metaId: MetaIdChartXAxis
  var valueOptionId: String? = null
}