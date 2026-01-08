// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoColor
import com.neome.api.meta.base.Types.MetaIdChartYAxis
import com.neome.api.meta.base.Types.MetaIdField

interface DefnDtoChartYAxis
{
  val color: DefnDtoColor?
  val colorFieldId: MetaIdField?
  val colorVar: DefnDtoColor?
  val fieldId: MetaIdField
  val label: String?
  val metaId: MetaIdChartYAxis
}