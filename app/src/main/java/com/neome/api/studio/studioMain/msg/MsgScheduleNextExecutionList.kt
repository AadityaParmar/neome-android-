// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.msg

import com.neome.api.meta.base.dto.StudioVarValueScheduler
import com.neome.api.nucleus.base.msg.Msg

class MsgScheduleNextExecutionList : Msg() {
    var iterations: number? = null
    val studioVarValueScheduler: StudioVarValueScheduler
}
