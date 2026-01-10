package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioSetOfDate
import kotlinx.serialization.Serializable


@Serializable
data class StudioSetOfDateData(
    override val valueSet: List<String>
) : StudioSetOfDate
