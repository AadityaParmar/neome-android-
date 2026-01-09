package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnKindAutoEdge
import com.neome.api.meta.base.dto.EntVdAutoEdge
import com.neome.api.meta.base.dto.VdBase
import com.neome.core.common.serializer.sysId.MetaIdPipelineParamSer
import com.neome.core.common.serializer.sysId.MetaIdVdAutoEdgeSer
import com.neome.core.common.serializer.sysId.MetaIdVdAutoNodeSer
import kotlinx.serialization.Serializable


@Serializable
data class EntVdAutoEdgeData(
    override val uiVersion: String? = null,
    override val fromNodeHandleId: String? = null,
    @Serializable(with = MetaIdVdAutoNodeSer::class) override val fromNodeId: Types.MetaIdVdAutoNode,
    override val kind: EnumDefnKindAutoEdge,
    @Serializable(with = MetaIdVdAutoEdgeSer::class) override val metaId: Types.MetaIdVdAutoEdge,
    @Serializable(with = MetaIdPipelineParamSer::class) override val outputPipelineParamId: Types.MetaIdPipelineParam? = null,
    @Serializable(with = MetaIdVdAutoNodeSer::class) override val toNodeId: Types.MetaIdVdAutoNode,
    override val value: String? = null
) : EntVdAutoEdge
