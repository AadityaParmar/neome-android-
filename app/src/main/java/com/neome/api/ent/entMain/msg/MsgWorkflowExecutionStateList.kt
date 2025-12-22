// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.msg

import com.neome.api.ent.base.Types.EnumWorkflowResultKind
import com.neome.api.nucleus.base.msg.Msg

class MsgWorkflowExecutionStateList : Msg() {
    var filterWorkflowStateSet: EnumWorkflowResultKind[]? = null
    var from: string? = null
    var limit: number? = null
}
