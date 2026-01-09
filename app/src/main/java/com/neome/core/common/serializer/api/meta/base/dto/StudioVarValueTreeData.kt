package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.FieldDtoTree
import com.neome.api.meta.base.dto.StudioVarValueTree
import kotlinx.serialization.Serializable


@Serializable
data class StudioVarValueTreeData(
    override val value: FieldDtoTree? = null
) : StudioVarValueTree
