package com.neome.core.common.serializer.api.home.base.dto

import com.neome.api.core.base.Types.EnumDeeplinkActionType
import com.neome.api.core.base.dto.DeeplinkDataPayload
import com.neome.api.core.base.dto.DtoDeeplinkAvatar
import com.neome.api.home.base.dto.DeeplinkDataPayloadGroupInvite
import kotlinx.serialization.Serializable


@Serializable
data class DeeplinkDataPayloadGroupInviteData(
    override val deeplinkActionType: EnumDeeplinkActionType,
    override val groupAvatar: DtoDeeplinkAvatar
) : DeeplinkDataPayloadGroupInvite
