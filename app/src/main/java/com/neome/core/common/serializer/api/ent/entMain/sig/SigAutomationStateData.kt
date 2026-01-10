package com.neome.core.common.serializer.api.ent.entMain.sig

import com.neome.api.ent.base.dto.AutomationStepSummary
import com.neome.api.ent.base.dto.DtoAutomationVariableInfo
import com.neome.api.ent.entMain.sig.SigAutomationState
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.sig.Sig
import com.neome.core.common.serializer.api.ent.base.dto.AutomationStepSummaryData
import com.neome.core.common.serializer.api.ent.base.dto.DtoAutomationVariableInfoData
import com.neome.core.common.serializer.sysId.AutomationExecutionIdSer
import kotlinx.serialization.Serializable


@Serializable
data class SigAutomationStateData(
    @Serializable(with = AutomationExecutionIdSer::class) override val executionId: Types.AutomationExecutionId,
    override val summaryList: List<AutomationStepSummaryData>? = null,
    override val variables: List<DtoAutomationVariableInfoData>? = null
) : SigAutomationState
