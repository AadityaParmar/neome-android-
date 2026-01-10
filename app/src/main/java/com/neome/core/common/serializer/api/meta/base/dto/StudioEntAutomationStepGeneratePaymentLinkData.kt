package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnAutomationTerminateKind
import com.neome.api.meta.base.Types.EnumDefnKindAutomationStep
import com.neome.api.meta.base.Types.EnumDefnPaymentMethodKind
import com.neome.api.meta.base.dto.StudioBuildArgBinder
import com.neome.api.meta.base.dto.StudioEntAutomationStep
import com.neome.api.meta.base.dto.StudioEntAutomationStepGeneratePaymentLink
import com.neome.api.meta.base.dto.StudioValueVarIdCondition
import com.neome.core.common.serializer.api.meta.base.dto.StudioBuildArgBinderData
import com.neome.core.common.serializer.api.meta.base.dto.StudioValueVarIdConditionData
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdGridSer
import com.neome.core.common.serializer.sysId.MetaIdPipelineParamSer
import com.neome.core.common.serializer.sysId.MetaIdStepSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEntAutomationStepGeneratePaymentLinkData(
    override val description: String? = null,
    @Serializable(with = MetaIdPipelineParamSer::class) override val executionConditionInputPipelineVarId: Types.MetaIdPipelineParam? = null,
    override val executionConditionVarId: StudioValueVarIdConditionData? = null,
    override val kind: EnumDefnKindAutomationStep,
    @Serializable(with = MetaIdStepSer::class) override val metaId: Types.MetaIdStep,
    @Serializable(with = SymbolSer::class) override val name: Symbol,
    override val skipUpdateSpreadsheetTrigger: Boolean? = null,
    @Serializable(with = MetaIdFieldSer::class) override val terminateFieldId: Types.MetaIdField? = null,
    override val terminateKind: EnumDefnAutomationTerminateKind? = null,
    override val allowedPaymentMethodSet: List<EnumDefnPaymentMethodKind>? = null,
    override val amountValue: StudioBuildArgBinderData? = null,
    override val currencyValue: StudioBuildArgBinderData? = null,
    override val descriptionValue: StudioBuildArgBinderData? = null,
    override val expiryDurationValue: StudioBuildArgBinderData? = null,
    @Serializable(with = MetaIdPipelineParamSer::class) override val inputFormPipelineVarId: Types.MetaIdPipelineParam? = null,
    override val iterateOnGridFilterVarId: StudioValueVarIdConditionData? = null,
    @Serializable(with = MetaIdGridSer::class) override val iterateOnGridId: Types.MetaIdGrid? = null,
    @Serializable(with = MetaIdPipelineParamSer::class) override val outputFormPipelineVarId: Types.MetaIdPipelineParam? = null,
    @Serializable(with = MetaIdFieldSer::class) override val paymentLinkFieldId: Types.MetaIdField? = null,
    @Serializable(with = MetaIdFieldSer::class) override val referenceIdFieldId: Types.MetaIdField? = null,
    @Serializable(with = MetaIdFieldSer::class) override val spreadsheetRowIdFieldId: Types.MetaIdField? = null
) : StudioEntAutomationStepGeneratePaymentLink
