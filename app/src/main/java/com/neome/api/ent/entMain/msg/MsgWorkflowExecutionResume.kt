// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.msg

import com.neome.api.ent.base.Types.EnumWorkflowDebugActionKind
import com.neome.api.nucleus.base.msg.Msg
import com.neome.api.meta.base.Types.WorkflowExecutionId

open class MsgWorkflowExecutionResume : Msg()
{
  var debugAction: EnumWorkflowDebugActionKind? = null
  lateinit var executionId: WorkflowExecutionId
  var userOption: String? = null
}