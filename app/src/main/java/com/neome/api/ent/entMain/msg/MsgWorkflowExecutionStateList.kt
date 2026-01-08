// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.msg

import com.neome.api.ent.base.Types.EnumWorkflowResultKind
import com.neome.api.nucleus.base.msg.Msg

interface MsgWorkflowExecutionStateList : Msg
{
  val filterWorkflowStateSet: Array<EnumWorkflowResultKind>?
  val from: String?
  val limit: Long?
}