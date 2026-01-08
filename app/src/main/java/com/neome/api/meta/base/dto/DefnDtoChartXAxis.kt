// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoColor
import com.neome.api.meta.base.Types.MetaIdChartXAxis
import com.neome.api.meta.base.Types.MetaIdField

interface DefnDtoChartXAxis
{
  val color: DefnDtoColor?
  val colorFieldId: MetaIdField?
  val colorVar: DefnDtoColor?
  val label: String?
  val metaId: MetaIdChartXAxis
  val valueOptionId: String?
}