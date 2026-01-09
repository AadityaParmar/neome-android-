package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnThemeColor
import com.neome.api.meta.base.Types.EnumDefnThemeColorShade
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoColor
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoColorData(
    override val shade: EnumDefnThemeColorShade? = null,
    override val value: EnumDefnThemeColor? = null
) : StudioDtoColor
