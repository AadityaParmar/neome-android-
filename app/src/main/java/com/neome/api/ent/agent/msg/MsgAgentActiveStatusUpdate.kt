// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.agent.msg

import com.neome.api.meta.base.Types.EntId
import com.neome.api.nucleus.base.msg.Msg

class MsgAgentActiveStatusUpdate : Msg() {
    val active: boolean
    val entId: EntId
}
