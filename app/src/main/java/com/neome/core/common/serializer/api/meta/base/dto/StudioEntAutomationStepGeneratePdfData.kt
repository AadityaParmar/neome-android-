package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnAutomationTerminateKind
import com.neome.api.meta.base.Types.EnumDefnKindAutomationStep
import com.neome.api.meta.base.dto.StudioEntAutomationStepGenerateDocument
import com.neome.api.meta.base.dto.StudioEntAutomationStepGeneratePdf
import com.neome.api.meta.base.dto.StudioValueVarIdCondition
import com.neome.api.meta.base.dto.StudioValueVarIdText
import com.neome.core.common.serializer.api.meta.base.dto.StudioValueVarIdConditionData
import com.neome.core.common.serializer.api.meta.base.dto.StudioValueVarIdTextData
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import com.neome.core.common.serializer.sysId.MetaIdGridSer
import com.neome.core.common.serializer.sysId.MetaIdLayoutFormSer
import com.neome.core.common.serializer.sysId.MetaIdPipelineParamSer
import com.neome.core.common.serializer.sysId.MetaIdStepSer
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEntAutomationStepGeneratePdfData(
    override val description: String? = null,
    @Serializable(with = MetaIdPipelineParamSer::class) override val executionConditionInputPipelineVarId: Types.MetaIdPipelineParam? = null,
    override val executionConditionVarId: StudioValueVarIdConditionData? = null,
    override val kind: EnumDefnKindAutomationStep,
    @Serializable(with = MetaIdStepSer::class) override val metaId: Types.MetaIdStep,
    @Serializable(with = SymbolSer::class) override val name: Symbol,
    override val skipUpdateSpreadsheetTrigger: Boolean? = null,
    @Serializable(with = MetaIdFieldSer::class) override val terminateFieldId: Types.MetaIdField? = null,
    override val terminateKind: EnumDefnAutomationTerminateKind? = null,
    @Serializable(with = MetaIdLayoutFormSer::class) override val contentLayoutId: Types.MetaIdLayoutForm? = null,
    override val fileNameVarId: StudioValueVarIdTextData? = null,
    @Serializable(with = MetaIdVarSer::class) override val inputFormMappingVarId: Types.MetaIdVar? = null,
    @Serializable(with = MetaIdPipelineParamSer::class) override val inputFormPipelineVarId: Types.MetaIdPipelineParam? = null,
    override val iterateOnGridFilterVarId: StudioValueVarIdConditionData? = null,
    @Serializable(with = MetaIdGridSer::class) override val iterateOnGridId: Types.MetaIdGrid? = null,
    @Serializable(with = MetaIdPipelineParamSer::class) override val outputFormPipelineVarId: Types.MetaIdPipelineParam? = null,
    @Serializable(with = MetaIdLayoutFormSer::class) override val templateLayoutId: Types.MetaIdLayoutForm? = null,
    @Serializable(with = MetaIdFieldSer::class) override val pdfFieldId: Types.MetaIdField? = null,
    @Serializable(with = MetaIdFormSer::class) override val pdfFormId: Types.MetaIdForm? = null,
    @Serializable(with = MetaIdVarSer::class) override val pdfFormMappingVarId: Types.MetaIdVar? = null
) : StudioEntAutomationStepGeneratePdf
