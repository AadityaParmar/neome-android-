// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

class MobileNumber : GsonCto() {
    var countryCode: number? = null
    var nationalNumber: number? = null
}
