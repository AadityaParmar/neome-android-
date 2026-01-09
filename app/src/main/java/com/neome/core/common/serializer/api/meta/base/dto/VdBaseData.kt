package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.VdBase
import kotlinx.serialization.Serializable


@Serializable
data class VdBaseData(
    override val uiVersion: String? = null
) : VdBase
