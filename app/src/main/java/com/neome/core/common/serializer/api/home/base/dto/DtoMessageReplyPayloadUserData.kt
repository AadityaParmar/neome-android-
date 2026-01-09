package com.neome.core.common.serializer.api.home.base.dto

import com.neome.api.home.base.Types.EnumMessageType
import com.neome.api.home.base.dto.DtoMessageReplyPayload
import com.neome.api.home.base.dto.DtoMessageReplyPayloadUser
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.EntUserIdSer
import com.neome.core.common.serializer.sysId.MediaIdAvatarSer
import com.neome.core.common.serializer.sysId.MessageIdSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoMessageReplyPayloadUserData(
    @Serializable(with = MessageIdSer::class) override val messageId: Types.MessageId,
    override val messageType: EnumMessageType,
    @Serializable(with = EntUserIdSer::class) override val senderId: Types.EntUserId,
    @Serializable(with = MediaIdAvatarSer::class) override val mediaIdAvatar: Types.MediaIdAvatar? = null,
    override val userName: String
) : DtoMessageReplyPayloadUser
