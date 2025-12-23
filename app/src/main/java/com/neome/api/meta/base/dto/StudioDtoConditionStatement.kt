// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnConditionOperator
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioBuildArgBinder

open class StudioDtoConditionStatement : StudioBase()
{
  var lhs: StudioBuildArgBinder? = null
  var operator: EnumDefnConditionOperator? = null
  var rhs: StudioBuildArgBinder? = null
}