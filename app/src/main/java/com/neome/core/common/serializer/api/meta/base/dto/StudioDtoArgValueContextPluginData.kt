package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnArgBinderContext
import com.neome.api.meta.base.Types.EnumDefnArgBinderContextPlugin
import com.neome.api.meta.base.dto.StudioDtoArgValueContext
import com.neome.api.meta.base.dto.StudioDtoArgValueContextPlugin
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoArgValueContextPluginData(
    override val kind: EnumDefnArgBinderContext,
    override val attribute: EnumDefnArgBinderContextPlugin
) : StudioDtoArgValueContextPlugin
