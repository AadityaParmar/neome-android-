// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

class DtoMessagePayloadText : DtoMessagePayload() {
    var isUpdated: boolean? = null
    val text: string
}
