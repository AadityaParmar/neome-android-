// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.EnumDefnCompType
import com.neome.api.meta.base.Types.MetaIdComp

class DtoFieldFilter {
    val defnFieldType: EnumDefnCompType
    var label: string? = null
    val metaIdField: MetaIdComp
    val name: Symbol
    var valueList: DtoFieldFilterOption[]? = null
}
