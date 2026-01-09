package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.core.base.Types.EnumDeeplinkActionType
import com.neome.api.core.base.dto.DeeplinkDataPayload
import com.neome.api.ent.base.dto.DeeplinkDataPayloadEnt
import com.neome.api.ent.base.dto.DeeplinkDataPayloadEntHeader
import kotlinx.serialization.Serializable


@Serializable
data class DeeplinkDataPayloadEntData(
    override val deeplinkActionType: EnumDeeplinkActionType,
    override val header: DeeplinkDataPayloadEntHeader? = null
) : DeeplinkDataPayloadEnt
