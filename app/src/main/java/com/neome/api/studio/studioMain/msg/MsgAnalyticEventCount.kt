// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.msg

import com.neome.api.nucleus.base.Types.EnumAnalyticEventFilterKind
import com.neome.api.nucleus.base.msg.Msg

class MsgAnalyticEventCount : Msg() {
    val filter: EnumAnalyticEventFilterKind
}
