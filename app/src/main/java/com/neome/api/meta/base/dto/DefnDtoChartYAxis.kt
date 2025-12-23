// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoColor
import com.neome.api.meta.base.Types.MetaIdChartYAxis
import com.neome.api.meta.base.Types.MetaIdField

open class DefnDtoChartYAxis
{
  var color: DefnDtoColor? = null
  var colorFieldId: MetaIdField? = null
  var colorVar: DefnDtoColor? = null
  lateinit var fieldId: MetaIdField
  var label: String? = null
  lateinit var metaId: MetaIdChartYAxis
}