// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

open class MobileNumber : GsonCto() {
    var countryCode: Number? = null
    var nationalNumber: Number? = null
}
