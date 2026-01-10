package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoTableStyle
import com.neome.api.meta.base.dto.StudioMapOfTableStyle
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoTableStyleData
import com.neome.core.common.serializer.sysId.MetaIdTableStyleSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioMapOfTableStyleData(
    override val keys: List<@Serializable(with = MetaIdTableStyleSer::class) Types.MetaIdTableStyle>,
    override val map: Map<@Serializable(with = MetaIdTableStyleSer::class) Types.MetaIdTableStyle, StudioDtoTableStyleData>
) : StudioMapOfTableStyle
