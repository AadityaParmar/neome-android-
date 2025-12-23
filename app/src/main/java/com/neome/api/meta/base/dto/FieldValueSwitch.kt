// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import kotlin.properties.Delegates

open class FieldValueSwitch {
    var captureLocation: FieldValueLocation? = null
    var captureTime: String? = null
    var captureUser: FieldValueEntUserId? = null
    var value: Boolean by Delegates.notNull<Boolean>()
}
