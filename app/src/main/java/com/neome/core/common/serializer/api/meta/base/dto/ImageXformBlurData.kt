package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnKindImageXform
import com.neome.api.meta.base.dto.ImageXform
import com.neome.api.meta.base.dto.ImageXformBlur
import com.neome.api.meta.base.dto.StudioBuildArgBinder
import com.neome.core.common.serializer.api.meta.base.dto.StudioBuildArgBinderData
import kotlinx.serialization.Serializable


@Serializable
data class ImageXformBlurData(
    override val kind: EnumDefnKindImageXform? = null,
    override val value: StudioBuildArgBinderData? = null
) : ImageXformBlur
