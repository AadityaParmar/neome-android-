package com.neome.core.common.serializer.api

import com.neome.api.home.base.Types.EnumMessageType
import com.neome.api.meta.base.Types.ContactId


interface DtoMessagePayload {
    val isForwarded: Boolean?
    val mentionMap: Map<String, ContactId>?
    val messageType: EnumMessageType
    val dtoText: DefnDtoText?
}
