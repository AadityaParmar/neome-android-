// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.msg

import com.neome.api.meta.base.Types.MetaIdPipelineParam
import com.neome.api.meta.base.Types.MetaIdVdAutoNode
import com.neome.api.meta.base.Types.WorkflowExecutionId
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.nucleus.base.msg.Msg

class MsgWorkflowExecutionParamUpdate : Msg() {
    val branchNodeId: MetaIdVdAutoNode
    val executionId: WorkflowExecutionId
    val formValue: FormValueRaw
    val paramId: MetaIdPipelineParam
}
