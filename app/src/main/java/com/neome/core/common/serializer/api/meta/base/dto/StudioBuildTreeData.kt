package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.FieldDtoTree
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioBuildTree
import com.neome.core.common.serializer.api.meta.base.dto.FieldDtoTreeData
import kotlinx.serialization.Serializable


@Serializable
data class StudioBuildTreeData(
    override val dtoTree: FieldDtoTreeData
) : StudioBuildTree
