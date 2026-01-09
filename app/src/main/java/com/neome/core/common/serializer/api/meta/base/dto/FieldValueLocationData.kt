package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.FieldDtoLocation
import com.neome.api.meta.base.dto.FieldValueLocation
import kotlinx.serialization.Serializable


@Serializable
data class FieldValueLocationData(
    override val value: FieldDtoLocation
) : FieldValueLocation
