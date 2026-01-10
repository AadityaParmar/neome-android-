package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnDocFileExt
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioSetOfDocFileExt
import kotlinx.serialization.Serializable


@Serializable
data class StudioSetOfDocFileExtData(
    override val valueSet: List<EnumDefnDocFileExt>
) : StudioSetOfDocFileExt
