package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoColor
import com.neome.api.meta.base.dto.StudioDtoOption
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoOptionData(
    override val color: StudioDtoColor? = null,
    override val disabled: Boolean? = null,
    override val metaId: String,
    override val value: String
) : StudioDtoOption
