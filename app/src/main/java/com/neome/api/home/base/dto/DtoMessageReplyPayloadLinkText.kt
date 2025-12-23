// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

open class DtoMessageReplyPayloadLinkText : DtoMessageReplyPayload() {
    var imageUrl: String? = null
    lateinit var textSummary: String
}
