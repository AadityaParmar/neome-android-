package com.neome.core.common.serializer.api.core.base.dto

import com.neome.api.core.base.Types.EnumDeeplinkActionType
import com.neome.api.core.base.dto.DeeplinkDataPayload
import kotlinx.serialization.Serializable


@Serializable
data class DeeplinkDataPayloadData(
    override val deeplinkActionType: EnumDeeplinkActionType
) : DeeplinkDataPayload
