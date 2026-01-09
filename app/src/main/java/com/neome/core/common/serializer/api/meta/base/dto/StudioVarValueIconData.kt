package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioVarValueIcon
import kotlinx.serialization.Serializable


@Serializable
data class StudioVarValueIconData(
    override val value: String
) : StudioVarValueIcon
