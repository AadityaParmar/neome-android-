package com.neome.core.common.serializer.api.home.base.dto

import com.neome.api.home.base.Types.EnumMessageType
import com.neome.api.home.base.dto.DtoMessageReplyPayload
import com.neome.api.home.base.dto.DtoMessageReplyPayloadVideo
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.EntUserIdSer
import com.neome.core.common.serializer.sysId.MediaIdImageSer
import com.neome.core.common.serializer.sysId.MediaIdVideoSer
import com.neome.core.common.serializer.sysId.MessageIdSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoMessageReplyPayloadVideoData(
    @Serializable(with = MessageIdSer::class) override val messageId: Types.MessageId,
    override val messageType: EnumMessageType,
    @Serializable(with = EntUserIdSer::class) override val senderId: Types.EntUserId,
    override val durationMs: Long,
    @Serializable(with = MediaIdImageSer::class) override val mediaId: Types.MediaIdImage,
    @Serializable(with = MediaIdImageSer::class) override val mediaIdBlurImage: Types.MediaIdImage,
    @Serializable(with = MediaIdVideoSer::class) override val mediaIdVideo: Types.MediaIdVideo,
    override val primaryColor: String
) : DtoMessageReplyPayloadVideo
