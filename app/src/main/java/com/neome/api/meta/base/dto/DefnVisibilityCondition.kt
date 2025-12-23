// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnVisibilityOperator
import com.neome.api.meta.base.Types.MetaIdField

open class DefnVisibilityCondition {
    lateinit var lhs: MetaIdField
    lateinit var operator: EnumDefnVisibilityOperator
    var rhs: FieldDtoArg? = null
}
