package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnDay
import com.neome.api.meta.base.dto.FieldChipSetDay
import kotlinx.serialization.Serializable


@Serializable
data class FieldChipSetDayData(
    override val valueSet: Array<EnumDefnDay>
) : FieldChipSetDay
