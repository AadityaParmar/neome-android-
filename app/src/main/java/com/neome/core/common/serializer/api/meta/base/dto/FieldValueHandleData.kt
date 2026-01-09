package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.FieldValueHandle
import kotlinx.serialization.Serializable


@Serializable
data class FieldValueHandleData(
    override val value: String
) : FieldValueHandle
