package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioVarValueEmail
import kotlinx.serialization.Serializable


@Serializable
data class StudioVarValueEmailData(
    override val value: String? = null
) : StudioVarValueEmail
