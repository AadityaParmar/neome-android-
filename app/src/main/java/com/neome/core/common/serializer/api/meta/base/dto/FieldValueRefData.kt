package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.FieldValueRef
import kotlinx.serialization.Serializable


@Serializable
data class FieldValueRefData(
    override val value: String
) : FieldValueRef
