// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnErrorSeverity
import kotlin.properties.Delegates

open class FieldValueError {
    var errorCounter: Number by Delegates.notNull<Number>()
    var errorParameterSet: Array<String>? = null
    lateinit var errorReason: String
    lateinit var severity: EnumDefnErrorSeverity
}
