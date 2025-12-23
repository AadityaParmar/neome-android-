// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.msg

import com.neome.api.meta.base.Types.EntId
import com.neome.api.nucleus.base.Types.EnumAnalyticEventFilterKind
import com.neome.api.nucleus.base.msg.Msg

open class MsgClusterAnalyticEventCount : Msg() {
    var entIdSet: Array<EntId>? = null
    lateinit var filter: EnumAnalyticEventFilterKind
}
