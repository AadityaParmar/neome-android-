// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

open class FieldValueSignature {
    var captureLocation: FieldValueLocation? = null
    var captureTime: String? = null
    var captureUser: FieldValueEntUserId? = null
    lateinit var handle: String
    lateinit var signature: String
}
