package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.FieldDtoLocation
import com.neome.api.meta.base.dto.StudioVarValueLocation
import kotlinx.serialization.Serializable


@Serializable
data class StudioVarValueLocationData(
    override val value: FieldDtoLocation
) : StudioVarValueLocation
