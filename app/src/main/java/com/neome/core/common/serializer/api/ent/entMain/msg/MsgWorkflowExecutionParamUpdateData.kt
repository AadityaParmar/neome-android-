package com.neome.core.common.serializer.api.ent.entMain.msg

import com.neome.api.ent.entMain.msg.MsgWorkflowExecutionParamUpdate
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.api.meta.base.dto.FormValueRawData
import com.neome.core.common.serializer.sysId.MetaIdPipelineParamSer
import com.neome.core.common.serializer.sysId.MetaIdVdAutoNodeSer
import com.neome.core.common.serializer.sysId.WorkflowExecutionIdSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgWorkflowExecutionParamUpdateData(
    @Serializable(with = MetaIdVdAutoNodeSer::class) override val branchNodeId: Types.MetaIdVdAutoNode,
    @Serializable(with = WorkflowExecutionIdSer::class) override val executionId: Types.WorkflowExecutionId,
    override val formValue: FormValueRawData,
    @Serializable(with = MetaIdPipelineParamSer::class) override val paramId: Types.MetaIdPipelineParam
) : MsgWorkflowExecutionParamUpdate
