package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.ent.base.Types.EnumWorkflowResultKind
import com.neome.api.ent.base.dto.DtoWorkflowExecutionStateInfo
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnKindAutoNode
import com.neome.api.meta.base.dto.DefnStudioMapOfDtoOption
import com.neome.api.meta.base.dto.EnvValidationError
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioMapOfDtoOptionData
import com.neome.core.common.serializer.api.meta.base.dto.EnvValidationErrorData
import com.neome.core.common.serializer.sysId.WorkflowExecutionIdSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoWorkflowExecutionStateInfoData(
    override val callerName: String,
    override val canAdminResume: Boolean? = null,
    override val createdOn: String? = null,
    override val eventKind: EnumDefnKindAutoNode,
    @Serializable(with = WorkflowExecutionIdSer::class) override val executionId: Types.WorkflowExecutionId,
    override val failureError: EnvValidationErrorData? = null,
    override val message: String? = null,
    override val name: String,
    override val nodeName: String,
    override val resumeOptions: DefnStudioMapOfDtoOptionData? = null,
    override val stateKind: EnumWorkflowResultKind,
    override val updatedOn: String? = null
) : DtoWorkflowExecutionStateInfo
