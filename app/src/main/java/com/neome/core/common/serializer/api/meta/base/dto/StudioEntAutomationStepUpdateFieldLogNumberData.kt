package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnAutomationTerminateKind
import com.neome.api.meta.base.Types.EnumDefnKindAutomationStep
import com.neome.api.meta.base.Types.EnumDefnLogOperationKind
import com.neome.api.meta.base.dto.StudioBuildArgBinderHolder
import com.neome.api.meta.base.dto.StudioEntAutomationStep
import com.neome.api.meta.base.dto.StudioEntAutomationStepUpdateFieldLogNumber
import com.neome.api.meta.base.dto.StudioValueVarIdCondition
import com.neome.api.meta.base.dto.StudioValueVarIdText
import com.neome.core.common.serializer.api.meta.base.dto.StudioBuildArgBinderHolderData
import com.neome.core.common.serializer.api.meta.base.dto.StudioValueVarIdConditionData
import com.neome.core.common.serializer.api.meta.base.dto.StudioValueVarIdTextData
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdPipelineParamSer
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetSer
import com.neome.core.common.serializer.sysId.MetaIdStepSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEntAutomationStepUpdateFieldLogNumberData(
    override val description: String? = null,
    @Serializable(with = MetaIdPipelineParamSer::class) override val executionConditionInputPipelineVarId: Types.MetaIdPipelineParam? = null,
    override val executionConditionVarId: StudioValueVarIdConditionData? = null,
    override val kind: EnumDefnKindAutomationStep,
    @Serializable(with = MetaIdStepSer::class) override val metaId: Types.MetaIdStep,
    @Serializable(with = SymbolSer::class) override val name: Symbol,
    override val skipUpdateSpreadsheetTrigger: Boolean? = null,
    @Serializable(with = MetaIdFieldSer::class) override val terminateFieldId: Types.MetaIdField? = null,
    override val terminateKind: EnumDefnAutomationTerminateKind? = null,
    override val customMessageVarId: StudioValueVarIdTextData? = null,
    override val operation: EnumDefnLogOperationKind? = null,
    @Serializable(with = MetaIdFieldSer::class) override val rowFieldId: Types.MetaIdField? = null,
    @Serializable(with = MetaIdPipelineParamSer::class) override val sourcePipelineVarId: Types.MetaIdPipelineParam? = null,
    @Serializable(with = MetaIdFieldSer::class) override val targetFieldId: Types.MetaIdField? = null,
    @Serializable(with = MetaIdSpreadsheetSer::class) override val targetSpreadsheetId: Types.MetaIdSpreadsheet? = null,
    override val value: StudioBuildArgBinderHolderData? = null
) : StudioEntAutomationStepUpdateFieldLogNumber
