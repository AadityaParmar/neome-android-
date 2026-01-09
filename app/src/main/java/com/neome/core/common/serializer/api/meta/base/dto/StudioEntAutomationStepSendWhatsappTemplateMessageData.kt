package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnAutomationTerminateKind
import com.neome.api.meta.base.Types.EnumDefnKindAutomationStep
import com.neome.api.meta.base.dto.StudioEntAutomationStepSendMessageBase
import com.neome.api.meta.base.dto.StudioEntAutomationStepSendWhatsappTemplateMessage
import com.neome.api.meta.base.dto.StudioMapOfVarIdText
import com.neome.api.meta.base.dto.StudioValueVarIdCondition
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdGridSer
import com.neome.core.common.serializer.sysId.MetaIdPipelineParamSer
import com.neome.core.common.serializer.sysId.MetaIdRoleSer
import com.neome.core.common.serializer.sysId.MetaIdStepSer
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEntAutomationStepSendWhatsappTemplateMessageData(
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
    override val carouselCardMessageVarMap: StudioMapOfVarIdText? = null,
    @Serializable(with = MetaIdFieldSer::class) override val dataSourceFieldId: Types.MetaIdField? = null,
    @Serializable(with = MetaIdFieldSer::class) override val mediaFieldId: Types.MetaIdField? = null,
    override val messageVarMap: StudioMapOfVarIdText? = null,
    override val templateGroupId: String? = null
) : StudioEntAutomationStepSendWhatsappTemplateMessage
