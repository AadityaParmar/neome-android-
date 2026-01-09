package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.EntVdWorkflowControl
import com.neome.api.meta.base.dto.StudioBase
import com.neome.core.common.serializer.sysId.GhostIdSer
import com.neome.core.common.serializer.sysId.MetaIdPipelineParamSer
import com.neome.core.common.serializer.sysId.MetaIdPipelineVarSer
import com.neome.core.common.serializer.sysId.MetaIdVdAutoNodeSer
import kotlinx.serialization.Serializable


@Serializable
data class EntVdWorkflowControlData(
    @Serializable(with = MetaIdPipelineParamSer::class) override val inputParamId: Types.MetaIdPipelineParam? = null,
    @Serializable(with = GhostIdSer::class) override val metaId: Types.GhostId,
    @Serializable(with = MetaIdPipelineVarSer::class) override val outputParamId: Types.MetaIdPipelineVar? = null,
    override val sharedParamMap: Map<@Serializable(with = MetaIdPipelineVarSer::class) Types.MetaIdPipelineVar, @Serializable(with = MetaIdPipelineParamSer::class) Types.MetaIdPipelineParam>? = null,
    @Serializable(with = MetaIdVdAutoNodeSer::class) override val startNodeId: Types.MetaIdVdAutoNode? = null
) : EntVdWorkflowControl
