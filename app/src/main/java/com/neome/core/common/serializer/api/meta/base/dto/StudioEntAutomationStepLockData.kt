package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnAutomationTerminateKind
import com.neome.api.meta.base.Types.EnumDefnKindAutomationStep
import com.neome.api.meta.base.Types.EnumDefnLockOperation
import com.neome.api.meta.base.dto.FieldDtoDuration
import com.neome.api.meta.base.dto.StudioEntAutomationStep
import com.neome.api.meta.base.dto.StudioEntAutomationStepLock
import com.neome.api.meta.base.dto.StudioValueVarIdCondition
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdPipelineParamSer
import com.neome.core.common.serializer.sysId.MetaIdStepSer
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEntAutomationStepLockData(
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
    override val lockDuration: FieldDtoDuration? = null,
    @Serializable(with = MetaIdFieldSer::class) override val lockKeyFieldId: Types.MetaIdField? = null,
    override val operation: EnumDefnLockOperation? = null,
    @Serializable(with = MetaIdPipelineParamSer::class) override val sourcePipelineVarId: Types.MetaIdPipelineParam? = null
) : StudioEntAutomationStepLock
