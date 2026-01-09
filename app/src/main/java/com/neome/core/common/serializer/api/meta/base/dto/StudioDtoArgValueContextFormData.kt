package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnArgBinderContext
import com.neome.api.meta.base.Types.EnumDefnArgBinderContextForm
import com.neome.api.meta.base.dto.StudioDtoArgValueContext
import com.neome.api.meta.base.dto.StudioDtoArgValueContextForm
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoArgValueContextFormData(
    override val kind: EnumDefnArgBinderContext,
    override val attribute: EnumDefnArgBinderContextForm
) : StudioDtoArgValueContextForm
