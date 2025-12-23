// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.nucleus.base.dto

open class DescApiTypeBasic : DescApiType() {
    var importRef: String? = null
    var superCls: String? = null
    lateinit var value: String
}
