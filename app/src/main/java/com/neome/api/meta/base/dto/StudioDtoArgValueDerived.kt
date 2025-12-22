// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnCompType
import com.neome.api.meta.base.Types.MetaIdField

class StudioDtoArgValueDerived : StudioDtoArgValue() {
    val derivedFieldId: MetaIdField
    var derivedFieldType: EnumDefnCompType? = null
    var valueBoolean: boolean? = null
    var valueDate: string? = null
    var valueDouble: number? = null
    var valueLong: number? = null
    var valueOptionId: string? = null
    var valueText: string? = null
}
