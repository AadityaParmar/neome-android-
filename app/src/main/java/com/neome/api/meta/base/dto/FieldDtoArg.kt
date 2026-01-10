// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.SysId
import com.neome.api.meta.base.Types.MetaIdField

interface FieldDtoArg {
    val valueBoolean: Boolean?
    val valueDate: String?
    val valueDouble: Long?
    val valueFieldId: MetaIdField?
    val valueLong: Long?
    val valueSysId: SysId?
    val valueSysIdArray: List<SysId>?
    val valueSysIdSet: List<SysId>?
    val valueText: String?
    val valueTextArray: List<String>?
}
