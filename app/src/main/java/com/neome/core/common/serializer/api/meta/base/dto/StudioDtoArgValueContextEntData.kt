package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnArgBinderContext
import com.neome.api.meta.base.Types.EnumDefnArgBinderContextEnt
import com.neome.api.meta.base.dto.StudioDtoArgValueContext
import com.neome.api.meta.base.dto.StudioDtoArgValueContextEnt
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoArgValueContextEntData(
    override val kind: EnumDefnArgBinderContext,
    override val attribute: EnumDefnArgBinderContextEnt
) : StudioDtoArgValueContextEnt
