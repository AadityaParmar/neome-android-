package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.FieldChipSetTime
import com.neome.core.common.serializer.sysId.AnyTimeSer
import kotlinx.serialization.Serializable


@Serializable
data class FieldChipSetTimeData(
    override val valueSet: List<@Serializable(with = AnyTimeSer::class) Types.AnyTime>
) : FieldChipSetTime
