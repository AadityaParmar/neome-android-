// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnVisibilityOperator
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioBuildArgBinder

interface StudioDtoVisibilityCondition : StudioBase
{
  val lhs: MetaIdField
  val operator: EnumDefnVisibilityOperator
  val rhs: StudioBuildArgBinder?
}