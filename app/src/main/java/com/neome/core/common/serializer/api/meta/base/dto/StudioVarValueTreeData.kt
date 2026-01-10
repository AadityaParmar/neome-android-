package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.FieldDtoTree
import com.neome.api.meta.base.dto.StudioVarValueTree
import com.neome.core.common.serializer.api.meta.base.dto.FieldDtoTreeData
import kotlinx.serialization.Serializable


@Serializable
data class StudioVarValueTreeData(
    override val value: FieldDtoTreeData? = null
) : StudioVarValueTree
