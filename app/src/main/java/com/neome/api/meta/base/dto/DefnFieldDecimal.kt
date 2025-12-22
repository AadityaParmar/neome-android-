// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField

class DefnFieldDecimal : DefnFieldEditable() {
    var defaultFieldId: MetaIdField? = null
    var defaultValue: number? = null
    var defaultVar: number? = null
    var max: number? = null
    var maxFieldId: MetaIdField? = null
    var maxVar: number? = null
    var min: number? = null
    var minDisplayValue: number? = null
    var minFieldId: MetaIdField? = null
    var minVar: number? = null
    var numberFormat: string? = null
    var numberOfDigitsAfterPeriod: number? = null
    var numberOfDigitsAfterPeriodFieldId: MetaIdField? = null
    var numberOfDigitsAfterPeriodVar: number? = null
}
