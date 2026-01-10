package com.neome.core.common.serializer.api.home.base.dto

import com.neome.api.home.base.Types.EnumMessageType
import com.neome.api.home.base.dto.DtoMessagePayload
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.api.home.base.dto.DtoMessagePayloadAudioData
import com.neome.core.common.serializer.api.home.base.dto.DtoMessagePayloadImageData
import com.neome.core.common.serializer.api.home.base.dto.DtoMessagePayloadSeal
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
) : DtoMessagePayloadSeal, DtoMessagePayload

object DtoMessagePayloadSerializer : JsonContentPolymorphicSerializer<DtoMessagePayloadSeal>(
    DtoMessagePayloadSeal::class
) {
    override fun selectDeserializer(element: JsonElement): DeserializationStrategy<DtoMessagePayloadSeal> {
        val messageType = element.jsonObject["messageType"]?.jsonPrimitive?.content
        return when (messageType) {
            EnumMessageType.audio.value -> DtoMessagePayloadAudioData.serializer()
            EnumMessageType.camera.value -> DtoMessagePayloadData.serializer()
            EnumMessageType.document.value -> DtoMessagePayloadData.serializer()
            EnumMessageType.spreadsheetRow.value -> DtoMessagePayloadData.serializer()
            EnumMessageType.spreadsheetRowDeleted.value -> DtoMessagePayloadData.serializer()
            EnumMessageType.group.value -> DtoMessagePayloadData.serializer()
            EnumMessageType.groupAboutChange.value -> DtoMessagePayloadData.serializer()
            EnumMessageType.groupAvatarChange.value -> DtoMessagePayloadData.serializer()
            EnumMessageType.groupCreate.value -> DtoMessagePayloadData.serializer()
            EnumMessageType.groupExit.value -> DtoMessagePayloadData.serializer()
            EnumMessageType.groupJoinWithInvite.value -> DtoMessagePayloadData.serializer()
            EnumMessageType.groupMemberAdd.value -> DtoMessagePayloadData.serializer()
            EnumMessageType.groupMemberRemove.value -> DtoMessagePayloadData.serializer()
            EnumMessageType.groupNameChange.value -> DtoMessagePayloadData.serializer()
            EnumMessageType.image.value -> DtoMessagePayloadImageData.serializer()
            EnumMessageType.linkText.value -> DtoMessagePayloadData.serializer()
            EnumMessageType.location.value -> DtoMessagePayloadData.serializer()
            EnumMessageType.messageDeleted.value -> DtoMessagePayloadData.serializer()
            EnumMessageType.report.value -> DtoMessagePayloadData.serializer()
            EnumMessageType.spreadsheetPartition.value -> DtoMessagePayloadData.serializer()
            EnumMessageType.text.value -> DtoMessagePayloadTextData.serializer()
            EnumMessageType.user.value -> DtoMessagePayloadData.serializer()
            EnumMessageType.video.value -> DtoMessagePayloadData.serializer()
            EnumMessageType.voice.value -> DtoMessagePayloadData.serializer()
            else -> DtoMessagePayloadData.serializer()
        }
    }
}
