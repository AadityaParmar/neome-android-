package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.FieldDtoImage
import com.neome.api.meta.base.dto.FieldValueImage
import com.neome.core.common.serializer.api.meta.base.dto.FieldDtoImageData
import kotlinx.serialization.Serializable


@Serializable
data class FieldValueImageData(
    override val value: FieldDtoImageData
) : FieldValueImage
