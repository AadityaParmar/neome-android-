package com.neome.core.common.serializer.api.home.base.dto

import com.neome.api.core.base.Types.EnumDeeplinkActionType
import com.neome.api.core.base.dto.DeeplinkDataPayload
import com.neome.api.home.base.dto.DeeplinkDataPayloadSignIn
import kotlinx.serialization.Serializable


@Serializable
data class DeeplinkDataPayloadSignInData(
    override val deeplinkActionType: EnumDeeplinkActionType
) : DeeplinkDataPayloadSignIn
