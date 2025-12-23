// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.msg

import com.neome.api.core.base.msg.MsgVersion
import com.neome.api.meta.base.Types.WorkflowExecutionId

open class MsgWorkflowExecutionId : MsgVersion()
{
  lateinit var executionId: WorkflowExecutionId
}