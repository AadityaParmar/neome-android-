package com.neome.core.common.serializer.api.nucleus.api.sig

import com.neome.api.nucleus.api.sig.SigClassTree
import com.neome.api.nucleus.base.dto.DtoTreeNode
import com.neome.api.nucleus.base.sig.Sig
import com.neome.core.common.serializer.api.nucleus.base.dto.DtoTreeNodeData
import kotlinx.serialization.Serializable


@Serializable
data class SigClassTreeData(
    override val root: DtoTreeNodeData? = null
) : SigClassTree
