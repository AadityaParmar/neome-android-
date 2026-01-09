package com.neome.core.common.serializer.api.nucleus.base.dto

import com.neome.api.nucleus.base.dto.DtoTreeNode
import kotlinx.serialization.Serializable


@Serializable
data class DtoTreeNodeData(
    override val children: Array<DtoTreeNode>? = null,
    override val name: String
) : DtoTreeNode
