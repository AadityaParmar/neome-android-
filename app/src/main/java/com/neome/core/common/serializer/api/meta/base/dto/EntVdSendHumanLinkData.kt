package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnKindAutoNode
import com.neome.api.meta.base.Types.EnumDefnKindChannelType
import com.neome.api.meta.base.Types.EnumDefnNodeTerminateKind
import com.neome.api.meta.base.dto.EntVdAutoStepWithOutputAndError
import com.neome.api.meta.base.dto.EntVdSendHumanLink
import com.neome.api.meta.base.dto.FieldDtoDuration
import com.neome.api.meta.base.dto.Point
import com.neome.api.meta.base.dto.Size
import com.neome.api.meta.base.dto.StudioBuildArgBinder
import com.neome.api.meta.base.dto.StudioValueParagraph
import com.neome.api.meta.base.dto.StudioValueText
import com.neome.core.common.serializer.api.meta.base.dto.FieldDtoDurationData
import com.neome.core.common.serializer.api.meta.base.dto.PointData
import com.neome.core.common.serializer.api.meta.base.dto.SizeData
import com.neome.core.common.serializer.api.meta.base.dto.StudioBuildArgBinderData
import com.neome.core.common.serializer.api.meta.base.dto.StudioValueParagraphData
import com.neome.core.common.serializer.api.meta.base.dto.StudioValueTextData
import com.neome.core.common.serializer.sysId.MetaIdPipelineParamSer
import com.neome.core.common.serializer.sysId.MetaIdVdAutoNodeSer
import com.neome.core.common.serializer.sysId.MetaIdVdRegionSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class EntVdSendHumanLinkData(
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
    override val terminateKind: EnumDefnNodeTerminateKind? = null,
    @Serializable(with = MetaIdPipelineParamSer::class) override val embedFormParamId: Types.MetaIdPipelineParam? = null,
    override val expiryDatetime: FieldDtoDurationData? = null,
    override val fromHandle: StudioBuildArgBinderData? = null,
    override val maxClicks: Long? = null,
    override val message: StudioValueParagraphData? = null,
    override val reminders: Long? = null,
    override val sender: StudioBuildArgBinderData? = null,
    override val targetChannels: List<EnumDefnKindChannelType>? = null,
    override val title: StudioValueTextData? = null,
    override val toHandle: StudioBuildArgBinderData? = null
) : EntVdSendHumanLink
