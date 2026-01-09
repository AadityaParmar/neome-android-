package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.FieldDtoDuration
import com.neome.api.meta.base.dto.FieldValueDuration
import kotlinx.serialization.Serializable


@Serializable
data class FieldValueDurationData(
    override val value: FieldDtoDuration
) : FieldValueDuration
