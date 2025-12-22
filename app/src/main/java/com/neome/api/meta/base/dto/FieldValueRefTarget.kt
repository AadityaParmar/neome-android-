// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.RowId

class FieldValueRefTarget {
    var displayValue: string? = null
    val token: string
    val value: RowId
    var version: string? = null
}
