// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.nucleus.base.dto

open class DescApiTypeSysId : DescApiType() {
    var importRef: String? = null
    lateinit var superClass: String
    lateinit var value: String
}
