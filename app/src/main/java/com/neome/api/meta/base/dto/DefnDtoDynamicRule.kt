// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnCompType
import com.neome.api.meta.base.Types.MetaIdFieldDynamicRule

class DefnDtoDynamicRule {
    val conditionNode: DefnMapOfDynamicCondition
    val fieldType: EnumDefnCompType
    val metaId: MetaIdFieldDynamicRule
    var optionMap: DefnStudioMapOfDtoOption? = null
}
