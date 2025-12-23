// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.EnumDefnCompType
import com.neome.api.meta.base.Types.MetaIdComp

open class DtoFieldFilter {
    lateinit var defnFieldType: EnumDefnCompType
    var label: String? = null
    lateinit var metaIdField: MetaIdComp
    lateinit var name: Symbol
    var valueList: Array<DtoFieldFilterOption>? = null
}
