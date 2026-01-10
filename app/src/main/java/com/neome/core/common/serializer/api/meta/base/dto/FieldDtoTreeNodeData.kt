package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.FieldDtoTreeNode
import com.neome.api.meta.base.dto.StudioBase
import com.neome.core.common.serializer.api.meta.base.dto.FieldDtoTreeNodeData
import kotlinx.serialization.Serializable


@Serializable
data class FieldDtoTreeNodeData(
    override val keys: List<String>,
    override val map: Map<String, FieldDtoTreeNodeData>,
    override val metaId: String,
    override val value: String? = null
) : FieldDtoTreeNode
