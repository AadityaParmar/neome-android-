package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnKindAiProvider
import com.neome.api.meta.base.Types.EnumDefnKindAutoNode
import com.neome.api.meta.base.Types.EnumDefnNodeTerminateKind
import com.neome.api.meta.base.dto.EntVdAi
import com.neome.api.meta.base.dto.EntVdAiWithOutput
import com.neome.api.meta.base.dto.Point
import com.neome.api.meta.base.dto.Size
import com.neome.api.meta.base.dto.StudioValueParagraph
import com.neome.core.common.serializer.sysId.MetaIdPipelineParamSer
import com.neome.core.common.serializer.sysId.MetaIdVdAutoNodeSer
import com.neome.core.common.serializer.sysId.MetaIdVdRegionSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class EntVdAiWithOutputData(
    override val uiVersion: String? = null,
    override val kind: EnumDefnKindAutoNode,
    override val logMsg: StudioValueParagraph? = null,
    @Serializable(with = MetaIdVdAutoNodeSer::class) override val metaId: Types.MetaIdVdAutoNode,
    @Serializable(with = SymbolSer::class) override val name: Symbol,
    @Serializable(with = MetaIdVdRegionSer::class) override val parentRegionId: Types.MetaIdVdRegion? = null,
    override val point: Point? = null,
    override val size: Size? = null,
    override val terminateKind: EnumDefnNodeTerminateKind? = null,
    override val aiInstructions: StudioValueParagraph? = null,
    override val aiProvider: EnumDefnKindAiProvider? = null,
    @Serializable(with = MetaIdPipelineParamSer::class) override val outputParamId: Types.MetaIdPipelineParam? = null,
    override val outputParamName: String? = null
) : EntVdAiWithOutput
