package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.FieldValueEmail
import kotlinx.serialization.Serializable


@Serializable
data class FieldValueEmailData(
    override val value: String
) : FieldValueEmail
