package com.neome.core.common.serializer.api.app.base.dto

import com.neome.api.app.base.Types.EnumKindNeoScript
import com.neome.api.app.base.dto.DtoNeoScript
import kotlinx.serialization.Serializable


@Serializable
data class DtoNeoScriptData(
    override val kind: EnumKindNeoScript
) : DtoNeoScript
