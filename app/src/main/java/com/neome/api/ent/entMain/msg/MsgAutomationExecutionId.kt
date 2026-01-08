// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.msg

import com.neome.api.meta.base.Types.AutomationExecutionId
import com.neome.api.core.base.msg.MsgVersion

interface MsgAutomationExecutionId : MsgVersion
{
  val automationExecutionId: AutomationExecutionId
}