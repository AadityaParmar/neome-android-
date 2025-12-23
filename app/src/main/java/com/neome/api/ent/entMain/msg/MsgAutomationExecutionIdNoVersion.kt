// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.msg

import com.neome.api.meta.base.Types.AutomationExecutionId
import com.neome.api.nucleus.base.msg.Msg

open class MsgAutomationExecutionIdNoVersion : Msg() {
    lateinit var automationExecutionId: AutomationExecutionId
}
