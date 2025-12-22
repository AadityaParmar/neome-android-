// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnConditionOperator
import com.neome.api.meta.base.Types.MetaIdCondition

class DefnDtoConditionStatement {
    val lhs: FieldDtoArg
    val metaId: MetaIdCondition
    var operator: EnumDefnConditionOperator? = null
    var rhs: FieldDtoArg? = null
}
