// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

class FieldValueCamera : FieldValueImage() {
    var captureLocation: FieldValueLocation? = null
    var captureTime: string? = null
    var captureUser: FieldValueEntUserId? = null
}
