// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.msg

import com.neome.api.nucleus.base.msg.Msg
import com.neome.api.meta.base.Types.WorkflowExecutionId

open class MsgWorkflowExecutionIdNoVersion : Msg()
{
  lateinit var executionId: WorkflowExecutionId
}