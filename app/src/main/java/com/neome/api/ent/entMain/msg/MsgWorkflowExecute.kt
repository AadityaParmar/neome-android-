// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.msg

import com.neome.api.meta.base.dto.EntVdWorkflowPointer
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.meta.base.Types.MetaIdAutomation
import com.neome.api.nucleus.base.msg.Msg

interface MsgWorkflowExecute : Msg
{
  val automationId: MetaIdAutomation?
  val formValue: FormValueRaw
  val workflowPointer: EntVdWorkflowPointer?
}