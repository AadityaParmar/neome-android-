package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.FieldValueHyperlink
import kotlinx.serialization.Serializable


@Serializable
data class FieldValueHyperlinkData(
    override val value: String
) : FieldValueHyperlink
