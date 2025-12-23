// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.msg

import com.neome.api.meta.base.Types.MetaIdPipelineParam
import com.neome.api.meta.base.Types.MetaIdVdAutoNode
import com.neome.api.meta.base.Types.WorkflowExecutionId
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.nucleus.base.msg.Msg

open class MsgWorkflowExecutionParamUpdate : Msg() {
    lateinit var branchNodeId: MetaIdVdAutoNode
    lateinit var executionId: WorkflowExecutionId
    lateinit var formValue: FormValueRaw
    lateinit var paramId: MetaIdPipelineParam
}
