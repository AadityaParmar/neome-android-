package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.FieldDtoDuration
import com.neome.api.meta.base.dto.StudioVarValueDuration
import com.neome.core.common.serializer.api.meta.base.dto.FieldDtoDurationData
import kotlinx.serialization.Serializable


@Serializable
data class StudioVarValueDurationData(
    override val value: FieldDtoDurationData
) : StudioVarValueDuration
