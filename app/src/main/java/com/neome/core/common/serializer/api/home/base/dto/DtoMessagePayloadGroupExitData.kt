package com.neome.core.common.serializer.api.home.base.dto

import com.neome.api.home.base.Types.EnumMessageType
import com.neome.api.home.base.dto.DtoGroupMemberKey
import com.neome.api.home.base.dto.DtoMessagePayload
import com.neome.api.home.base.dto.DtoMessagePayloadGroupExit
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.api.home.base.dto.DtoMessagePayloadSeal
import com.neome.core.common.serializer.sysId.ContactIdSer
import kotlinx.serialization.Serializable


@Serializable
sealed interface DtoMessagePayloadGroupExitSeal : DtoMessagePayloadGroupExit


@Serializable
data class DtoMessagePayloadGroupExitData(
    override val isForwarded: Boolean? = null,
    override val mentionMap: Map<String, @Serializable(with = ContactIdSer::class) Types.ContactId>? = null,
    override val messageType: EnumMessageType,
    override val initiatorMember: DtoGroupMemberKey
) : DtoMessagePayloadSeal, DtoMessagePayloadGroupExit
