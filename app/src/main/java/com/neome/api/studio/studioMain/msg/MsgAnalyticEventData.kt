// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.msg

import com.neome.api.core.base.Types.EnumTimeDuration
import com.neome.api.nucleus.base.Types.EnumAnalyticEventType
import com.neome.api.nucleus.base.msg.Msg

open class MsgAnalyticEventData : Msg() {
    lateinit var duration: EnumTimeDuration
    lateinit var eventType: EnumAnalyticEventType
}
