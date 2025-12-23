// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.SysId
import com.neome.api.meta.base.Types.MetaIdField

open class FieldDtoArg {
    var valueBoolean: Boolean? = null
    var valueDate: String? = null
    var valueDouble: Number? = null
    var valueFieldId: MetaIdField? = null
    var valueLong: Number? = null
    var valueSysId: SysId? = null
    var valueSysIdArray: Array<SysId>? = null
    var valueSysIdSet: Array<SysId>? = null
    var valueText: String? = null
    var valueTextArray: Array<String>? = null
}
