package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.EntVdAiAgentControl
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioValueParagraph
import com.neome.api.meta.base.dto.StudioValueText
import com.neome.core.common.serializer.api.meta.base.dto.StudioValueParagraphData
import com.neome.core.common.serializer.api.meta.base.dto.StudioValueTextData
import com.neome.core.common.serializer.sysId.GhostIdSer
import com.neome.core.common.serializer.sysId.MetaIdPipelineParamSer
import com.neome.core.common.serializer.sysId.MetaIdPipelineVarSer
import com.neome.core.common.serializer.sysId.MetaIdVdAutoNodeSer
import kotlinx.serialization.Serializable


@Serializable
data class EntVdAiAgentControlData(
    override val description: StudioValueParagraphData? = null,
    @Serializable(with = GhostIdSer::class) override val metaId: Types.GhostId,
    override val name: StudioValueTextData? = null,
    override val sharedParamMap: Map<@Serializable(with = MetaIdPipelineVarSer::class) Types.MetaIdPipelineVar, @Serializable(with = MetaIdPipelineParamSer::class) Types.MetaIdPipelineParam>? = null,
    @Serializable(with = MetaIdVdAutoNodeSer::class) override val startNodeId: Types.MetaIdVdAutoNode? = null
) : EntVdAiAgentControl
