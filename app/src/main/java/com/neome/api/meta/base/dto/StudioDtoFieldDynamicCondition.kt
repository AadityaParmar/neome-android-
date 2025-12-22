// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnDynamicOperator
import com.neome.api.meta.base.Types.MetaIdField

class StudioDtoFieldDynamicCondition : StudioBase() {
    val lhs: MetaIdField
    val operator: EnumDefnDynamicOperator
    var rhs: StudioBuildArgBinder? = null
}
