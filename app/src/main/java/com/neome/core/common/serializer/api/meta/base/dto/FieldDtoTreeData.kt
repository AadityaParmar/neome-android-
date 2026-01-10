package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.FieldDtoTree
import com.neome.api.meta.base.dto.FieldDtoTreeNode
import com.neome.core.common.serializer.api.meta.base.dto.FieldDtoTreeNodeData
import kotlinx.serialization.Serializable


@Serializable
data class FieldDtoTreeData(
    override val keys: List<String>,
    override val map: Map<String, FieldDtoTreeNodeData>
) : FieldDtoTree
