// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.msg

import java.util.Date
import com.neome.api.ent.base.Types.EnumWorkflowResultKind
import com.neome.api.nucleus.base.msg.Msg

open class MsgWorkflowExecutionStateList : Msg()
{
  var filterWorkflowStateSet: Array<EnumWorkflowResultKind>? = null
  var from: String? = null
  var limit: Number? = null
}