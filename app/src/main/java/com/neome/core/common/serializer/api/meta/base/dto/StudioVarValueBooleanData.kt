package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioVarValueBoolean
import kotlinx.serialization.Serializable


@Serializable
data class StudioVarValueBooleanData(
    override val value: Boolean
) : StudioVarValueBoolean
