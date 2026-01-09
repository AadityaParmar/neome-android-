package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.FieldDtoTreeNode
import com.neome.api.meta.base.dto.StudioBase
import kotlinx.serialization.Serializable


@Serializable
data class FieldDtoTreeNodeData(
    override val keys: Array<String>,
    override val map: Map<String, FieldDtoTreeNode>,
    override val metaId: String,
    override val value: String? = null
) : FieldDtoTreeNode
