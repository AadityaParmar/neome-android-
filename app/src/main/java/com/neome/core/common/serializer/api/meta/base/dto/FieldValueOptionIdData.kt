package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.FieldValueOptionId
import kotlinx.serialization.Serializable


@Serializable
data class FieldValueOptionIdData(
    override val optionId: String,
    override val value: String? = null
) : FieldValueOptionId
