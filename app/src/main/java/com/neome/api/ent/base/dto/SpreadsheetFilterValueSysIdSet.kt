// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.SysId

interface SpreadsheetFilterValueSysIdSet : SpreadsheetFilterValue {
    val valueSet: List<SysId>
}
