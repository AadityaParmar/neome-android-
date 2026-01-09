package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnAutomationTerminateKind
import com.neome.api.meta.base.Types.EnumDefnKindAutomationStep
import com.neome.api.meta.base.dto.StudioEntAutomationStep
import com.neome.api.meta.base.dto.StudioEntAutomationStepCallPlugin
import com.neome.api.meta.base.dto.StudioValueVarIdCondition
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdGridSer
import com.neome.core.common.serializer.sysId.MetaIdPipelineParamSer
import com.neome.core.common.serializer.sysId.MetaIdPluginSer
import com.neome.core.common.serializer.sysId.MetaIdStepSer
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import com.neome.core.common.serializer.sysId.PluginApiIdSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEntAutomationStepCallPluginData(
    override val description: String? = null,
    @Serializable(with = MetaIdPipelineParamSer::class) override val executionConditionInputPipelineVarId: Types.MetaIdPipelineParam? = null,
    override val executionConditionVarId: StudioValueVarIdCondition? = null,
    override val kind: EnumDefnKindAutomationStep,
    @Serializable(with = MetaIdStepSer::class) override val metaId: Types.MetaIdStep,
    @Serializable(with = SymbolSer::class) override val name: Symbol,
    override val skipUpdateSpreadsheetTrigger: Boolean? = null,
    @Serializable(with = MetaIdFieldSer::class) override val terminateFieldId: Types.MetaIdField? = null,
    override val terminateKind: EnumDefnAutomationTerminateKind? = null,
    @Serializable(with = MetaIdFieldSer::class) override val errorFieldId: Types.MetaIdField? = null,
    @Serializable(with = MetaIdVarSer::class) override val errorRetryCountVarId: Types.MetaIdVar? = null,
    @Serializable(with = MetaIdVarSer::class) override val errorRetryDurationVarId: Types.MetaIdVar? = null,
    override val exposeOutputAsPipelineVariable: Boolean? = null,
    @Serializable(with = MetaIdPipelineParamSer::class) override val inputFormPipelineVarId: Types.MetaIdPipelineParam? = null,
    override val iterateOnGridFilterVarId: StudioValueVarIdCondition? = null,
    @Serializable(with = MetaIdGridSer::class) override val iterateOnGridId: Types.MetaIdGrid? = null,
    @Serializable(with = MetaIdPipelineParamSer::class) override val outputFormPipelineVarId: Types.MetaIdPipelineParam? = null,
    @Serializable(with = MetaIdVarSer::class) override val pluginInputMappingVarId: Types.MetaIdVar? = null,
    @Serializable(with = MetaIdVarSer::class) override val pluginOutputMappingVarId: Types.MetaIdVar? = null,
    @Serializable(with = PluginApiIdSer::class) override val targetPluginApiId: Types.PluginApiId? = null,
    @Serializable(with = MetaIdPluginSer::class) override val targetPluginId: Types.MetaIdPlugin? = null
) : StudioEntAutomationStepCallPlugin
