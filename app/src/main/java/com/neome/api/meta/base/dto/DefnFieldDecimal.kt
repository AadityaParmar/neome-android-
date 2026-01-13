// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField

interface DefnFieldDecimal : DefnFieldEditable {
    val defaultFieldId: MetaIdField?
    val defaultValue: Double?
    val defaultVar: Double?
    val max: Double?
    val maxFieldId: MetaIdField?
    val maxVar: Double?
    val min: Double?
    val minDisplayValue: Double?
    val minFieldId: MetaIdField?
    val minVar: Double?
    val numberFormat: String?
    val numberOfDigitsAfterPeriod: Double?
    val numberOfDigitsAfterPeriodFieldId: MetaIdField?
    val numberOfDigitsAfterPeriodVar: Double?
}
