// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

interface DtoMessagePayloadText : DtoMessagePayload {
    val isUpdated: Boolean?
    val text: String
}
