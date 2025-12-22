// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnScanCodeType

class FieldValueScanCode {
    var captureLocation: FieldValueLocation? = null
    var captureTime: string? = null
    var captureUser: FieldValueEntUserId? = null
    val scanCode: string
    val scanCodeType: EnumDefnScanCodeType
}
