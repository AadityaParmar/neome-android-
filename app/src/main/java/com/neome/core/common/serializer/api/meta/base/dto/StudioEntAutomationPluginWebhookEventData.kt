package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnKindPluginWebhookEvent
import com.neome.api.meta.base.dto.StudioEntAutomationEvent
import com.neome.api.meta.base.dto.StudioEntAutomationPluginWebhookEvent
import com.neome.api.meta.base.dto.StudioEntAutomationStepMap
import com.neome.api.meta.base.dto.StudioEntPipelineVarMap
import com.neome.api.meta.base.dto.StudioValueVarIdCondition
import com.neome.core.common.serializer.api.meta.base.dto.StudioEntAutomationStepMapData
import com.neome.core.common.serializer.api.meta.base.dto.StudioEntPipelineVarMapData
import com.neome.core.common.serializer.api.meta.base.dto.StudioValueVarIdConditionData
import com.neome.core.common.serializer.sysId.MetaIdEventSer
import com.neome.core.common.serializer.sysId.MetaIdPipelineParamSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEntAutomationPluginWebhookEventData(
    override val description: String? = null,
    @Serializable(with = MetaIdPipelineParamSer::class) override val executionConditionInputPipelineVarId: Types.MetaIdPipelineParam? = null,
    override val executionConditionVarId: StudioValueVarIdConditionData? = null,
    @Serializable(with = MetaIdEventSer::class) override val metaId: Types.MetaIdEvent,
    @Serializable(with = SymbolSer::class) override val name: Symbol,
    override val pipelineVarMap: StudioEntPipelineVarMapData? = null,
    override val secondary: String? = null,
    override val stepMap: StudioEntAutomationStepMapData,
    override val fire: EnumDefnKindPluginWebhookEvent
) : StudioEntAutomationPluginWebhookEvent
