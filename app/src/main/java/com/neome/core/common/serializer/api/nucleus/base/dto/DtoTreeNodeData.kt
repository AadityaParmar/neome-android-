package com.neome.core.common.serializer.api.nucleus.base.dto

import com.neome.api.nucleus.base.dto.DtoTreeNode
import com.neome.core.common.serializer.api.nucleus.base.dto.DtoTreeNodeData
import kotlinx.serialization.Serializable


@Serializable
data class DtoTreeNodeData(
    override val children: List<DtoTreeNodeData>? = null,
    override val name: String
) : DtoTreeNode
