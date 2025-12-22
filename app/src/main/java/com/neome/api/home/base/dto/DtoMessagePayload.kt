// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.home.base.Types.EnumMessageType
import com.neome.api.meta.base.Types.ContactId

class DtoMessagePayload {
    var isForwarded: boolean? = null
    var mentionMap: Record<string, ContactId>? = null
    val messageType: EnumMessageType
}
