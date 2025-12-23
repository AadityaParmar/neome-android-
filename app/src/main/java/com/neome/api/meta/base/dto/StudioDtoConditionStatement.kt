// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnConditionOperator

open class StudioDtoConditionStatement : StudioBase() {
    var lhs: StudioBuildArgBinder? = null
    var operator: EnumDefnConditionOperator? = null
    var rhs: StudioBuildArgBinder? = null
}
