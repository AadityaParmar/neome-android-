// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnVisibilityOperator
import com.neome.api.meta.base.dto.FieldDtoArg
import com.neome.api.meta.base.Types.MetaIdField

interface DefnVisibilityCondition
{
  val lhs: MetaIdField
  val operator: EnumDefnVisibilityOperator
  val rhs: FieldDtoArg?
}