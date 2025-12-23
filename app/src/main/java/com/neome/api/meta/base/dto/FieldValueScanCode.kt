// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnScanCodeType

open class FieldValueScanCode {
    var captureLocation: FieldValueLocation? = null
    var captureTime: String? = null
    var captureUser: FieldValueEntUserId? = null
    lateinit var scanCode: String
    lateinit var scanCodeType: EnumDefnScanCodeType
}
