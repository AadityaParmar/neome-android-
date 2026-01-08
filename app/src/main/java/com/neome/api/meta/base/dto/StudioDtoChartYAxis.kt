// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdChartYAxis
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoColor
import com.neome.api.meta.base.Symbol

interface StudioDtoChartYAxis : StudioBase
{
  val color: StudioDtoColor?
  val colorFieldId: MetaIdField?
  val colorVarId: MetaIdVar?
  val fieldId: MetaIdField?
  val label: String?
  val metaId: MetaIdChartYAxis
  val name: Symbol?
}