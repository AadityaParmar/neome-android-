// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

class FieldValueSignature {
    var captureLocation: FieldValueLocation? = null
    var captureTime: string? = null
    var captureUser: FieldValueEntUserId? = null
    val handle: string
    val signature: string
}
