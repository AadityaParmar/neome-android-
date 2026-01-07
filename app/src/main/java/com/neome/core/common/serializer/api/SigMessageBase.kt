package com.neome.core.common.serializer.api

import com.neome.api.meta.base.Types

interface SigMessageBase {
    var creationTime: String
    var isCallerSender: Boolean?

    var messageId: Types.MessageId
    var messageOffset: Int?
    var payload: DtoMessagePayload
}
