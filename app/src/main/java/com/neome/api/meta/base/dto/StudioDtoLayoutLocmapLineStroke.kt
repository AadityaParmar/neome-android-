// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnThemeStroke
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoColor

open class StudioDtoLayoutLocmapLineStroke : StudioBase()
{
  var color: StudioDtoColor? = null
  var colorFieldId: MetaIdField? = null
  var colorVarId: MetaIdVar? = null
  var groupByFieldId: MetaIdField? = null
  var stroke: EnumDefnThemeStroke? = null
  var strokeFieldId: MetaIdField? = null
  var strokeVarId: MetaIdVar? = null
}