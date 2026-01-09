package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnKindImageXform
import com.neome.api.meta.base.dto.ImageXform
import com.neome.api.meta.base.dto.StudioBase
import kotlinx.serialization.Serializable


@Serializable
data class ImageXformData(
    override val kind: EnumDefnKindImageXform? = null
) : ImageXform
