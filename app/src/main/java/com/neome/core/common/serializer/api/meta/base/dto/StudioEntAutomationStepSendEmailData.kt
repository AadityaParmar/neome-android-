package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnAutomationTerminateKind
import com.neome.api.meta.base.Types.EnumDefnKindAutomationStep
import com.neome.api.meta.base.dto.StudioEntAutomationStepSendEmail
import com.neome.api.meta.base.dto.StudioEntAutomationStepSendMessageBase
import com.neome.api.meta.base.dto.StudioValueVarIdCondition
import com.neome.api.meta.base.dto.StudioValueVarIdParagraph
import com.neome.api.meta.base.dto.StudioValueVarIdText
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdGridSer
import com.neome.core.common.serializer.sysId.MetaIdPipelineParamSer
import com.neome.core.common.serializer.sysId.MetaIdRoleSer
import com.neome.core.common.serializer.sysId.MetaIdStepSer
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEntAutomationStepSendEmailData(
    override val description: String? = null,
    @Serializable(with = MetaIdPipelineParamSer::class) override val executionConditionInputPipelineVarId: Types.MetaIdPipelineParam? = null,
    override val executionConditionVarId: StudioValueVarIdCondition? = null,
    override val kind: EnumDefnKindAutomationStep,
    @Serializable(with = MetaIdStepSer::class) override val metaId: Types.MetaIdStep,
    @Serializable(with = SymbolSer::class) override val name: Symbol,
    override val skipUpdateSpreadsheetTrigger: Boolean? = null,
    @Serializable(with = MetaIdFieldSer::class) override val terminateFieldId: Types.MetaIdField? = null,
    override val terminateKind: EnumDefnAutomationTerminateKind? = null,
    override val dataSourceRoleIdSet: Array<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    @Serializable(with = MetaIdPipelineParamSer::class) override val inputFormPipelineVarId: Types.MetaIdPipelineParam? = null,
    override val iterateOnGridFilterVarId: StudioValueVarIdCondition? = null,
    @Serializable(with = MetaIdGridSer::class) override val iterateOnGridId: Types.MetaIdGrid? = null,
    @Serializable(with = MetaIdVarSer::class) override val setOfUserVarId: Types.MetaIdVar? = null,
    @Serializable(with = MetaIdPipelineParamSer::class) override val targetDataSourcePipelineVarId: Types.MetaIdPipelineParam? = null,
    override val bccFieldIdSet: Array<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    @Serializable(with = MetaIdVarSer::class) override val bccSetOfUserVarId: Types.MetaIdVar? = null,
    override val ccFieldIdSet: Array<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    @Serializable(with = MetaIdVarSer::class) override val ccSetOfUserVarId: Types.MetaIdVar? = null,
    @Serializable(with = MetaIdFieldSer::class) override val mediaFieldId: Types.MetaIdField? = null,
    override val messageVarId: StudioValueVarIdParagraph? = null,
    @Serializable(with = MetaIdFieldSer::class) override val replyToFieldId: Types.MetaIdField? = null,
    @Serializable(with = MetaIdVarSer::class) override val replyToSetOfUserVarId: Types.MetaIdVar? = null,
    override val subjectVarId: StudioValueVarIdText? = null,
    override val toFieldIdSet: Array<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null
) : StudioEntAutomationStepSendEmail
