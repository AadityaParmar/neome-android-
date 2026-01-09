package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.ent.base.Types.EnumAutomationStateKind
import com.neome.api.ent.base.dto.DtoAutomationStateInfo
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnKindAutomation
import com.neome.api.meta.base.dto.EnvValidationError
import com.neome.core.common.serializer.sysId.AutomationExecutionIdSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoAutomationStateInfoData(
    override val callerName: String,
    override val createdOn: String? = null,
    override val eventName: String,
    @Serializable(with = AutomationExecutionIdSer::class) override val executionId: Types.AutomationExecutionId,
    override val failureError: EnvValidationError? = null,
    override val kind: EnumDefnKindAutomation,
    override val message: String? = null,
    override val name: String,
    override val stateKind: EnumAutomationStateKind,
    override val stepName: String,
    override val updatedOn: String? = null
) : DtoAutomationStateInfo
