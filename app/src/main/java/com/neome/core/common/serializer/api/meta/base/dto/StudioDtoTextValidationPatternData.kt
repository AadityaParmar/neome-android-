package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnTextValidationPattern
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoTextValidationPattern
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoTextValidationPatternData(
    override val customValue: String? = null,
    override val value: EnumDefnTextValidationPattern? = null
) : StudioDtoTextValidationPattern
