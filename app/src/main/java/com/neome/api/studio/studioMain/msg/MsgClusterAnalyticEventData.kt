// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.msg

import com.neome.api.core.base.Types.EnumTimeDuration
import com.neome.api.meta.base.Types.EntId
import com.neome.api.nucleus.base.Types.EnumAnalyticEventType
import com.neome.api.nucleus.base.msg.Msg

open class MsgClusterAnalyticEventData : Msg() {
    lateinit var duration: EnumTimeDuration
    var entIdSet: Array<EntId>? = null
    lateinit var eventType: EnumAnalyticEventType
}
