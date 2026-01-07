package com.neome.core.common.serializer.api

interface DtoMessagePayloadText : DtoMessagePayload {
    var isUpdated: Boolean?
    var text: String
}
