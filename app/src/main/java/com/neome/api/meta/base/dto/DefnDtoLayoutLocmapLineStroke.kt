// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoColor
import com.neome.api.meta.base.Types.EnumDefnThemeStroke
import com.neome.api.meta.base.Types.MetaIdField

open class DefnDtoLayoutLocmapLineStroke
{
  var color: DefnDtoColor? = null
  var colorFieldId: MetaIdField? = null
  var colorVar: DefnDtoColor? = null
  var groupByFieldId: MetaIdField? = null
  var stroke: EnumDefnThemeStroke? = null
  var strokeFieldId: MetaIdField? = null
  var strokeVar: EnumDefnThemeStroke? = null
}