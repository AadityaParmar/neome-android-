package com.neome.core.common.serializer.api.home.base.dto

import com.neome.api.home.base.Types.EnumMessageType
import com.neome.api.home.base.dto.DtoMessagePayloadAudio
import com.neome.api.home.base.dto.DtoMessagePayloadText
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.api.home.base.dto.DtoMessagePayloadSeal
import com.neome.core.common.serializer.sysId.ContactIdSer
import com.neome.core.common.serializer.sysId.MediaIdAudioSer
import kotlinx.serialization.Serializable


@Serializable
sealed interface DtoMessagePayloadAudioSeal : DtoMessagePayloadAudio


@Serializable
data class DtoMessagePayloadAudioData(
    override val isForwarded: Boolean? = null,
    override val mentionMap: Map<String, @Serializable(with = ContactIdSer::class) Types.ContactId>? = null,
    override val messageType: EnumMessageType = EnumMessageType.audio,
    override val isUpdated: Boolean? = null,
    override val text: String,
    override val durationMs: Long? = null,
    override val fileSize: Long? = null,
    @Serializable(with = MediaIdAudioSer::class) override val mediaIdAudio: Types.MediaIdAudio
) : DtoMessagePayloadSeal, DtoMessagePayloadAudio
