// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnKindHyperlink
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioDtoColor

open class StudioVarValueHyperlink
{
  var color: StudioDtoColor? = null
  var colorVarId: MetaIdVar? = null
  var displayText: String? = null
  var kind: EnumDefnKindHyperlink? = null
  var value: String? = null
}