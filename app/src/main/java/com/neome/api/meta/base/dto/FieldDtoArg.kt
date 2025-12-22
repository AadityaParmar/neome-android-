// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.SysId
import com.neome.api.meta.base.Types.MetaIdField

class FieldDtoArg {
    var valueBoolean: boolean? = null
    var valueDate: string? = null
    var valueDouble: number? = null
    var valueFieldId: MetaIdField? = null
    var valueLong: number? = null
    var valueSysId: SysId? = null
    var valueSysIdArray: SysId[]? = null
    var valueSysIdSet: SysId[]? = null
    var valueText: string? = null
    var valueTextArray: string[]? = null
}
