// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.msg

import com.neome.api.ent.base.Types.EnumAutomationStateFilterKind
import com.neome.api.nucleus.base.msg.Msg

class MsgAutomationStateInfoList : Msg() {
    var filterAutomationStateSet: EnumAutomationStateFilterKind[]? = null
    var from: string? = null
    var limit: number? = null
}
