// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.sig

import com.neome.api.nucleus.base.Types.EnumAnalyticEventType
import com.neome.api.nucleus.base.sig.Sig
import java.util.Map

open class SigAnalyticData : Sig() {
    lateinit var eventDataMap: Map<EnumAnalyticEventType, SigAnalyticEventData>
}
