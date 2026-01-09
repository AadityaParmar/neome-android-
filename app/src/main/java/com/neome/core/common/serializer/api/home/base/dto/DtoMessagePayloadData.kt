package com.neome.core.common.serializer.api.home.base.dto

import com.neome.api.home.base.Types.EnumMessageType
import com.neome.api.home.base.dto.DtoMessagePayload
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.api.home.base.dto.DtoMessagePayloadAudioData
import com.neome.core.common.serializer.api.home.base.dto.DtoMessagePayloadImageData
import com.neome.core.common.serializer.api.home.base.dto.DtoMessagePayloadTextData
import com.neome.core.common.serializer.sysId.ContactIdSer
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive


@Serializable(with = DtoMessagePayloadSerializer::class)
sealed interface DtoMessagePayloadSeal : DtoMessagePayload


@Serializable
data class DtoMessagePayloadData(
    override val isForwarded: Boolean? = null,
    override val mentionMap: Map<String, @Serializable(with = ContactIdSer::class) Types.ContactId>? = null,
    override val messageType: EnumMessageType
) : DtoMessagePayload

object DtoMessagePayloadSerializer : JsonContentPolymorphicSerializer<DtoMessagePayloadSeal>(
    DtoMessagePayloadSeal::class
) {
    override fun selectDeserializer(element: JsonElement): DeserializationStrategy<DtoMessagePayloadSeal> {
        val messageType = element.jsonObject["messageType"]?.jsonPrimitive?.content
        return when (messageType) {
            EnumMessageType.audio.value -> DtoMessagePayloadAudioData.serializer()
            EnumMessageType.camera.value -> DtoMessagePayloadSeal.serializer()
            EnumMessageType.document.value -> DtoMessagePayloadSeal.serializer()
            EnumMessageType.spreadsheetRow.value -> DtoMessagePayloadSeal.serializer()
            EnumMessageType.spreadsheetRowDeleted.value -> DtoMessagePayloadSeal.serializer()
            EnumMessageType.group.value -> DtoMessagePayloadSeal.serializer()
            EnumMessageType.groupAboutChange.value -> DtoMessagePayloadSeal.serializer()
            EnumMessageType.groupAvatarChange.value -> DtoMessagePayloadSeal.serializer()
            EnumMessageType.groupCreate.value -> DtoMessagePayloadSeal.serializer()
            EnumMessageType.groupExit.value -> DtoMessagePayloadSeal.serializer()
            EnumMessageType.groupJoinWithInvite.value -> DtoMessagePayloadSeal.serializer()
            EnumMessageType.groupMemberAdd.value -> DtoMessagePayloadSeal.serializer()
            EnumMessageType.groupMemberRemove.value -> DtoMessagePayloadSeal.serializer()
            EnumMessageType.groupNameChange.value -> DtoMessagePayloadSeal.serializer()
            EnumMessageType.image.value -> DtoMessagePayloadImageData.serializer()
            EnumMessageType.linkText.value -> DtoMessagePayloadSeal.serializer()
            EnumMessageType.location.value -> DtoMessagePayloadSeal.serializer()
            EnumMessageType.messageDeleted.value -> DtoMessagePayloadSeal.serializer()
            EnumMessageType.report.value -> DtoMessagePayloadSeal.serializer()
            EnumMessageType.spreadsheetPartition.value -> DtoMessagePayloadSeal.serializer()
            EnumMessageType.text.value -> DtoMessagePayloadTextData.serializer()
            EnumMessageType.user.value -> DtoMessagePayloadSeal.serializer()
            EnumMessageType.video.value -> DtoMessagePayloadSeal.serializer()
            EnumMessageType.voice.value -> DtoMessagePayloadSeal.serializer()
            else -> DtoMessagePayloadSeal.serializer()
        }
    }
}
