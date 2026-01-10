package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnAutomationTerminateKind
import com.neome.api.meta.base.Types.EnumDefnKindAutomationStep
import com.neome.api.meta.base.dto.StudioEntAutomationStep
import com.neome.api.meta.base.dto.StudioEntAutomationStepGenerateDeeplink
import com.neome.api.meta.base.dto.StudioValueVarIdCondition
import com.neome.core.common.serializer.api.meta.base.dto.StudioValueVarIdConditionData
import com.neome.core.common.serializer.sysId.MetaIdActionSer
import com.neome.core.common.serializer.sysId.MetaIdDeeplinkSer
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdGridSer
import com.neome.core.common.serializer.sysId.MetaIdPipelineParamSer
import com.neome.core.common.serializer.sysId.MetaIdStepSer
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEntAutomationStepGenerateDeeplinkData(
    override val description: String? = null,
    @Serializable(with = MetaIdPipelineParamSer::class) override val executionConditionInputPipelineVarId: Types.MetaIdPipelineParam? = null,
    override val executionConditionVarId: StudioValueVarIdConditionData? = null,
    override val kind: EnumDefnKindAutomationStep,
    @Serializable(with = MetaIdStepSer::class) override val metaId: Types.MetaIdStep,
    @Serializable(with = SymbolSer::class) override val name: Symbol,
    override val skipUpdateSpreadsheetTrigger: Boolean? = null,
    @Serializable(with = MetaIdFieldSer::class) override val terminateFieldId: Types.MetaIdField? = null,
    override val terminateKind: EnumDefnAutomationTerminateKind? = null,
    @Serializable(with = MetaIdFieldSer::class) override val deeplinkFieldId: Types.MetaIdField? = null,
    @Serializable(with = MetaIdDeeplinkSer::class) override val deeplinkId: Types.MetaIdDeeplink? = null,
    @Serializable(with = MetaIdVarSer::class) override val inputFormMappingVarId: Types.MetaIdVar? = null,
    @Serializable(with = MetaIdPipelineParamSer::class) override val inputFormPipelineVarId: Types.MetaIdPipelineParam? = null,
    override val iterateOnGridFilterVarId: StudioValueVarIdConditionData? = null,
    @Serializable(with = MetaIdGridSer::class) override val iterateOnGridId: Types.MetaIdGrid? = null,
    @Serializable(with = MetaIdPipelineParamSer::class) override val outputFormPipelineVarId: Types.MetaIdPipelineParam? = null,
    @Serializable(with = MetaIdActionSer::class) override val spreadsheetEditorActionId: Types.MetaIdAction? = null
) : StudioEntAutomationStepGenerateDeeplink
