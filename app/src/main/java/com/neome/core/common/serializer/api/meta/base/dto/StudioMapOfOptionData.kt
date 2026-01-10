package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoOption
import com.neome.api.meta.base.dto.StudioMapOfOption
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoOptionData
import kotlinx.serialization.Serializable


@Serializable
data class StudioMapOfOptionData(
    override val addTextColor: Boolean? = null,
    override val keys: List<String>,
    override val map: Map<String, StudioDtoOptionData>
) : StudioMapOfOption
