// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnMapOfDynamicCondition
import com.neome.api.meta.base.dto.DefnStudioMapOfDtoOption
import com.neome.api.meta.base.Types.EnumDefnCompType
import com.neome.api.meta.base.Types.MetaIdFieldDynamicRule

open class DefnDtoDynamicRule
{
  lateinit var conditionNode: DefnMapOfDynamicCondition
  lateinit var fieldType: EnumDefnCompType
  lateinit var metaId: MetaIdFieldDynamicRule
  var optionMap: DefnStudioMapOfDtoOption? = null
}