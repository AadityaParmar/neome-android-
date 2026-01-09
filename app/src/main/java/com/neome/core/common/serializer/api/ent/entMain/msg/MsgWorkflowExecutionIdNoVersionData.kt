package com.neome.core.common.serializer.api.ent.entMain.msg

import com.neome.api.ent.entMain.msg.MsgWorkflowExecutionIdNoVersion
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.sysId.WorkflowExecutionIdSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgWorkflowExecutionIdNoVersionData(
    @Serializable(with = WorkflowExecutionIdSer::class) override val executionId: Types.WorkflowExecutionId
) : MsgWorkflowExecutionIdNoVersion
