// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnDynamicOperator
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioBuildArgBinder

open class StudioDtoFieldDynamicCondition : StudioBase()
{
  lateinit var lhs: MetaIdField
  lateinit var operator: EnumDefnDynamicOperator
  var rhs: StudioBuildArgBinder? = null
}