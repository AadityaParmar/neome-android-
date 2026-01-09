package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.FieldDtoImage
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoPlaceHolder
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoPlaceHolderData(
    override val image: FieldDtoImage? = null,
    override val primaryText: String? = null,
    override val secondaryText: String? = null
) : StudioDtoPlaceHolder
