package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnDate
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioBuildDate
import kotlinx.serialization.Serializable


@Serializable
data class StudioBuildDateData(
    override val customValue: String? = null,
    override val value: EnumDefnDate? = null
) : StudioBuildDate
