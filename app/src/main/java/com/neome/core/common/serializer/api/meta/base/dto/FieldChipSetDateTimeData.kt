package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.FieldChipSetDateTime
import kotlinx.serialization.Serializable


@Serializable
data class FieldChipSetDateTimeData(
    override val valueSet: Array<String>
) : FieldChipSetDateTime
