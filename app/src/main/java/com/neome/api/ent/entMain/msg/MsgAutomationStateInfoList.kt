// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.msg

import java.util.Date
import com.neome.api.ent.base.Types.EnumAutomationStateFilterKind
import com.neome.api.nucleus.base.msg.Msg

open class MsgAutomationStateInfoList : Msg()
{
  var filterAutomationStateSet: Array<EnumAutomationStateFilterKind>? = null
  var from: String? = null
  var limit: Number? = null
}