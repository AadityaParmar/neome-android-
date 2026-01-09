package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnKindAutoXform
import com.neome.api.meta.base.dto.AutoXform
import com.neome.api.meta.base.dto.StudioBase
import kotlinx.serialization.Serializable


@Serializable
data class AutoXformData(
    override val kind: EnumDefnKindAutoXform? = null
) : AutoXform
