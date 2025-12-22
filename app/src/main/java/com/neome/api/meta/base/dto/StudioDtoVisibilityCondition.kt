// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnVisibilityOperator
import com.neome.api.meta.base.Types.MetaIdField

class StudioDtoVisibilityCondition : StudioBase() {
    val lhs: MetaIdField
    val operator: EnumDefnVisibilityOperator
    var rhs: StudioBuildArgBinder? = null
}
