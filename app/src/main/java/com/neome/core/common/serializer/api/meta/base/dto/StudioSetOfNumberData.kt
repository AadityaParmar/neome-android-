package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioSetOfNumber
import kotlinx.serialization.Serializable


@Serializable
data class StudioSetOfNumberData(
    override val valueSet: List<Long>
) : StudioSetOfNumber
