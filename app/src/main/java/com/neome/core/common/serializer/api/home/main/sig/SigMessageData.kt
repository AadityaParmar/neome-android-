package com.neome.core.common.serializer.api.home.main.sig

import com.neome.api.home.base.Types.EnumReceiptStatus
import com.neome.api.home.base.dto.DtoMessagePayload
import com.neome.api.home.base.dto.DtoMessageReaction
import com.neome.api.home.base.dto.DtoMessageReplyPayload
import com.neome.api.home.main.sig.SigMessage
import com.neome.api.home.main.sig.SigMessageBase
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.api.home.base.dto.DtoMessagePayloadSeal
import com.neome.core.common.serializer.api.home.base.dto.DtoMessageReactionData
import com.neome.core.common.serializer.api.home.base.dto.DtoMessageReplyPayloadData
import com.neome.core.common.serializer.sysId.EntUserIdSer
import com.neome.core.common.serializer.sysId.MessageIdSer
import kotlinx.serialization.Serializable


@Serializable
data class SigMessageData(
    override val creationTime: String,
    override val isCallerSender: Boolean? = null,
    @Serializable(with = MessageIdSer::class) override val messageId: Types.MessageId,
    override val messageOffset: Long,
    override val payload: DtoMessagePayloadSeal,
    override val reactionMap: Map<@Serializable(with = EntUserIdSer::class) Types.EntUserId, DtoMessageReactionData>? = null,
    override val replyPayload: DtoMessageReplyPayloadData? = null,
    @Serializable(with = EntUserIdSer::class) override val senderId: Types.EntUserId,
    override val receiptStatus: EnumReceiptStatus? = null,
    override val version: String? = null
) : SigMessage
