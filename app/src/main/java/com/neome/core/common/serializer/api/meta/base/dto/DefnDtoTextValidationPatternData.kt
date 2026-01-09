package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnTextValidationPattern
import com.neome.api.meta.base.dto.DefnDtoTextValidationPattern
import kotlinx.serialization.Serializable


@Serializable
data class DefnDtoTextValidationPatternData(
    override val customValue: String? = null,
    override val value: EnumDefnTextValidationPattern? = null
) : DefnDtoTextValidationPattern
