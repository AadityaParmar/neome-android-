package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoOption
import com.neome.api.meta.base.dto.DefnStudioMapOfDtoOption
import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoOptionData
import kotlinx.serialization.Serializable


@Serializable
data class DefnStudioMapOfDtoOptionData(
    override val keys: List<String>,
    override val map: Map<String, DefnDtoOptionData>
) : DefnStudioMapOfDtoOption
