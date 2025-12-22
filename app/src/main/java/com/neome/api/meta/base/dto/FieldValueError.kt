// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnErrorSeverity

class FieldValueError {
    val errorCounter: number
    var errorParameterSet: string[]? = null
    val errorReason: string
    val severity: EnumDefnErrorSeverity
}
