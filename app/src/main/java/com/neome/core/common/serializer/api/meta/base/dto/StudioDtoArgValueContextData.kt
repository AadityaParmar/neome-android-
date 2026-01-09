package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnArgBinderContext
import com.neome.api.meta.base.dto.StudioDtoArgValue
import com.neome.api.meta.base.dto.StudioDtoArgValueContext
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoArgValueContextData(
    override val kind: EnumDefnArgBinderContext
) : StudioDtoArgValueContext
