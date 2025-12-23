// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

open class StudioValueParagraph : StudioValueVarIdBase() {
    var paramSet: Array<String>? = null
    lateinit var value: String
}
