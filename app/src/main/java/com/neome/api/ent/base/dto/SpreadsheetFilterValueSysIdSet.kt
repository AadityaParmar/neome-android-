// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.SysId

open class SpreadsheetFilterValueSysIdSet : SpreadsheetFilterValue() {
    lateinit var valueSet: Array<SysId>
}
