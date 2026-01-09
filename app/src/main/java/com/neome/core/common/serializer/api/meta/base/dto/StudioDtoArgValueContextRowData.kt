package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnArgBinderContext
import com.neome.api.meta.base.Types.EnumDefnArgBinderContextRow
import com.neome.api.meta.base.dto.StudioDtoArgValueContext
import com.neome.api.meta.base.dto.StudioDtoArgValueContextRow
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoArgValueContextRowData(
    override val kind: EnumDefnArgBinderContext,
    override val attribute: EnumDefnArgBinderContextRow,
    override val fromAlias: String? = null
) : StudioDtoArgValueContextRow
