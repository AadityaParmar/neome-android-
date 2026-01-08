// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnThemeStroke
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoColor

interface StudioDtoLayoutLocmapLineStroke : StudioBase
{
  val color: StudioDtoColor?
  val colorFieldId: MetaIdField?
  val colorVarId: MetaIdVar?
  val groupByFieldId: MetaIdField?
  val stroke: EnumDefnThemeStroke?
  val strokeFieldId: MetaIdField?
  val strokeVarId: MetaIdVar?
}