package com.neome.core.common.serializer.api.home.base.dto

import com.neome.api.home.base.Types.EnumMessageType
import com.neome.api.home.base.dto.DtoMessagePayload
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.api.home.base.dto.DtoMessagePayloadAudioData
import com.neome.core.common.serializer.api.home.base.dto.DtoMessagePayloadCameraData
import com.neome.core.common.serializer.api.home.base.dto.DtoMessagePayloadDocumentData
import com.neome.core.common.serializer.api.home.base.dto.DtoMessagePayloadGroupAboutChangeData
import com.neome.core.common.serializer.api.home.base.dto.DtoMessagePayloadGroupAvatarChangeData
import com.neome.core.common.serializer.api.home.base.dto.DtoMessagePayloadGroupCreateData
import com.neome.core.common.serializer.api.home.base.dto.DtoMessagePayloadGroupData
import com.neome.core.common.serializer.api.home.base.dto.DtoMessagePayloadGroupExitData
import com.neome.core.common.serializer.api.home.base.dto.DtoMessagePayloadGroupJoinWithInviteData
import com.neome.core.common.serializer.api.home.base.dto.DtoMessagePayloadGroupMemberAddData
import com.neome.core.common.serializer.api.home.base.dto.DtoMessagePayloadGroupMemberRemoveData
import com.neome.core.common.serializer.api.home.base.dto.DtoMessagePayloadGroupNameChangeData
import com.neome.core.common.serializer.api.home.base.dto.DtoMessagePayloadImageData
import com.neome.core.common.serializer.api.home.base.dto.DtoMessagePayloadLinkTextData
import com.neome.core.common.serializer.api.home.base.dto.DtoMessagePayloadLocationData
import com.neome.core.common.serializer.api.home.base.dto.DtoMessagePayloadMessageDeletedData
import com.neome.core.common.serializer.api.home.base.dto.DtoMessagePayloadReportData
import com.neome.core.common.serializer.api.home.base.dto.DtoMessagePayloadSeal
import com.neome.core.common.serializer.api.home.base.dto.DtoMessagePayloadSpreadsheetPartitionData
import com.neome.core.common.serializer.api.home.base.dto.DtoMessagePayloadSpreadsheetRowData
import com.neome.core.common.serializer.api.home.base.dto.DtoMessagePayloadSpreadsheetRowDeletedData
import com.neome.core.common.serializer.api.home.base.dto.DtoMessagePayloadTextData
import com.neome.core.common.serializer.api.home.base.dto.DtoMessagePayloadUserData
import com.neome.core.common.serializer.api.home.base.dto.DtoMessagePayloadVideoData
import com.neome.core.common.serializer.api.home.base.dto.DtoMessagePayloadVoiceData
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
            EnumMessageType.camera.value -> DtoMessagePayloadCameraData.serializer()
            EnumMessageType.document.value -> DtoMessagePayloadDocumentData.serializer()
            EnumMessageType.spreadsheetRow.value -> DtoMessagePayloadSpreadsheetRowData.serializer()
            EnumMessageType.spreadsheetRowDeleted.value -> DtoMessagePayloadSpreadsheetRowDeletedData.serializer()
            EnumMessageType.group.value -> DtoMessagePayloadGroupData.serializer()
            EnumMessageType.groupAboutChange.value -> DtoMessagePayloadGroupAboutChangeData.serializer()
            EnumMessageType.groupAvatarChange.value -> DtoMessagePayloadGroupAvatarChangeData.serializer()
            EnumMessageType.groupCreate.value -> DtoMessagePayloadGroupCreateData.serializer()
            EnumMessageType.groupExit.value -> DtoMessagePayloadGroupExitData.serializer()
            EnumMessageType.groupJoinWithInvite.value -> DtoMessagePayloadGroupJoinWithInviteData.serializer()
            EnumMessageType.groupMemberAdd.value -> DtoMessagePayloadGroupMemberAddData.serializer()
            EnumMessageType.groupMemberRemove.value -> DtoMessagePayloadGroupMemberRemoveData.serializer()
            EnumMessageType.groupNameChange.value -> DtoMessagePayloadGroupNameChangeData.serializer()
            EnumMessageType.image.value -> DtoMessagePayloadImageData.serializer()
            EnumMessageType.linkText.value -> DtoMessagePayloadLinkTextData.serializer()
            EnumMessageType.location.value -> DtoMessagePayloadLocationData.serializer()
            EnumMessageType.messageDeleted.value -> DtoMessagePayloadMessageDeletedData.serializer()
            EnumMessageType.report.value -> DtoMessagePayloadReportData.serializer()
            EnumMessageType.spreadsheetPartition.value -> DtoMessagePayloadSpreadsheetPartitionData.serializer()
            EnumMessageType.text.value -> DtoMessagePayloadTextData.serializer()
            EnumMessageType.user.value -> DtoMessagePayloadUserData.serializer()
            EnumMessageType.video.value -> DtoMessagePayloadVideoData.serializer()
            EnumMessageType.voice.value -> DtoMessagePayloadVoiceData.serializer()
            else -> DtoMessagePayloadData.serializer()
        }
    }
}
