package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnMonth
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioSetOfMonth
import kotlinx.serialization.Serializable


@Serializable
data class StudioSetOfMonthData(
    override val valueSet: List<EnumDefnMonth>
) : StudioSetOfMonth
