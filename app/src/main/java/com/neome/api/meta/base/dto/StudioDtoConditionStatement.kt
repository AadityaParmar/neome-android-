// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnConditionOperator
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioBuildArgBinder

interface StudioDtoConditionStatement : StudioBase
{
  val lhs: StudioBuildArgBinder?
  val operator: EnumDefnConditionOperator?
  val rhs: StudioBuildArgBinder?
}