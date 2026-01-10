package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnKindAutoNode
import com.neome.api.meta.base.Types.EnumDefnKindPipelineUpdate
import com.neome.api.meta.base.dto.EntVdAutoStepWithOutput
import com.neome.api.meta.base.dto.EntVdParamCreate
import com.neome.api.meta.base.dto.FormRefKey
import com.neome.api.meta.base.dto.Point
import com.neome.api.meta.base.dto.Size
import com.neome.api.meta.base.dto.StudioDtoMapping
import com.neome.api.meta.base.dto.StudioValueParagraph
import com.neome.core.common.serializer.api.meta.base.dto.FormRefKeyData
import com.neome.core.common.serializer.api.meta.base.dto.PointData
import com.neome.core.common.serializer.api.meta.base.dto.SizeData
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoMappingData
import com.neome.core.common.serializer.api.meta.base.dto.StudioValueParagraphData
import com.neome.core.common.serializer.sysId.MetaIdPipelineParamSer
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import com.neome.core.common.serializer.sysId.MetaIdVdAutoNodeSer
import com.neome.core.common.serializer.sysId.MetaIdVdRegionSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class EntVdParamCreateData(
    override val uiVersion: String? = null,
    override val kind: EnumDefnKindAutoNode,
    override val logMsg: StudioValueParagraphData? = null,
    @Serializable(with = MetaIdVdAutoNodeSer::class) override val metaId: Types.MetaIdVdAutoNode,
    @Serializable(with = SymbolSer::class) override val name: Symbol,
    @Serializable(with = MetaIdVdRegionSer::class) override val parentRegionId: Types.MetaIdVdRegion? = null,
    override val point: PointData? = null,
    override val size: SizeData? = null,
    @Serializable(with = MetaIdPipelineParamSer::class) override val outputParamId: Types.MetaIdPipelineParam? = null,
    override val outputParamName: String? = null,
    override val option: EnumDefnKindPipelineUpdate? = null,
    override val outputForm: FormRefKeyData? = null,
    override val outputMapping: StudioDtoMappingData? = null,
    @Serializable(with = MetaIdVarSer::class) override val outputMappingVarId: Types.MetaIdVar? = null
) : EntVdParamCreate
