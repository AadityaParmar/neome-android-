// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

open class DtoMessagePayloadText : DtoMessagePayload() {
    var isUpdated: Boolean? = null
    lateinit var text: String
}
