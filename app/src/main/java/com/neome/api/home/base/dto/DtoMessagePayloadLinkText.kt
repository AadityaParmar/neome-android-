// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

class DtoMessagePayloadLinkText : DtoMessagePayloadText() {
    var pageIconUrl: string? = null
    var pageSubTitle: string? = null
    var pageTitle: string? = null
    val pageUrl: string
}
