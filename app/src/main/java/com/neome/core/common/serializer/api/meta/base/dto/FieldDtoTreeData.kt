package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.FieldDtoTree
import com.neome.api.meta.base.dto.FieldDtoTreeNode
import kotlinx.serialization.Serializable


@Serializable
data class FieldDtoTreeData(
    override val keys: Array<String>,
    override val map: Map<String, FieldDtoTreeNode>
) : FieldDtoTree
