package com.neome.core.common.serializer.api.ent.entMain.msg

import com.neome.api.ent.base.Types.EnumWorkflowDebugActionKind
import com.neome.api.ent.entMain.msg.MsgWorkflowExecutionResume
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.sysId.WorkflowExecutionIdSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgWorkflowExecutionResumeData(
    override val debugAction: EnumWorkflowDebugActionKind? = null,
    @Serializable(with = WorkflowExecutionIdSer::class) override val executionId: Types.WorkflowExecutionId,
    override val userOption: String? = null
) : MsgWorkflowExecutionResume
