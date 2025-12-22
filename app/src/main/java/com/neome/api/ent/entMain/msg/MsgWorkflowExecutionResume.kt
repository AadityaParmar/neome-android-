// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.msg

import com.neome.api.ent.base.Types.EnumWorkflowDebugActionKind
import com.neome.api.meta.base.Types.WorkflowExecutionId
import com.neome.api.nucleus.base.msg.Msg

class MsgWorkflowExecutionResume : Msg() {
    var debugAction: EnumWorkflowDebugActionKind? = null
    val executionId: WorkflowExecutionId
    var userOption: string? = null
}
