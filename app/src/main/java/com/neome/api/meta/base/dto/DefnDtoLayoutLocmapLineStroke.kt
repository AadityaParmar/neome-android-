// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoColor
import com.neome.api.meta.base.Types.EnumDefnThemeStroke
import com.neome.api.meta.base.Types.MetaIdField

interface DefnDtoLayoutLocmapLineStroke
{
  val color: DefnDtoColor?
  val colorFieldId: MetaIdField?
  val colorVar: DefnDtoColor?
  val groupByFieldId: MetaIdField?
  val stroke: EnumDefnThemeStroke?
  val strokeFieldId: MetaIdField?
  val strokeVar: EnumDefnThemeStroke?
}