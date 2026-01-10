package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.FieldDtoImage
import com.neome.api.meta.base.dto.StudioVarValueImage
import com.neome.core.common.serializer.api.meta.base.dto.FieldDtoImageData
import kotlinx.serialization.Serializable


@Serializable
data class StudioVarValueImageData(
    override val value: FieldDtoImageData
) : StudioVarValueImage
