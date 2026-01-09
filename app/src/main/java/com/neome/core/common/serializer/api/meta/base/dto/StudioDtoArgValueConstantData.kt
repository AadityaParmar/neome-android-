package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnCompType
import com.neome.api.meta.base.dto.StudioDtoArgValue
import com.neome.api.meta.base.dto.StudioDtoArgValueConstant
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement


@Serializable
data class StudioDtoArgValueConstantData(
    override val type: EnumDefnCompType,
    override val value: JsonElement? = null
) : StudioDtoArgValueConstant
