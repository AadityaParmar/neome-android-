package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.FieldDtoImage
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoPlaceHolder
import com.neome.core.common.serializer.api.meta.base.dto.FieldDtoImageData
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoPlaceHolderData(
    override val image: FieldDtoImageData? = null,
    override val primaryText: String? = null,
    override val secondaryText: String? = null
) : StudioDtoPlaceHolder
