// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

open class StudioValueText : StudioValueVarIdBase() {
    var paramSet: Array<String>? = null
    lateinit var value: String
}
