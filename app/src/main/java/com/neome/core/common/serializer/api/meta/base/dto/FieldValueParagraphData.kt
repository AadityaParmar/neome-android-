package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.FieldValueParagraph
import kotlinx.serialization.Serializable


@Serializable
data class FieldValueParagraphData(
    override val value: String
) : FieldValueParagraph
