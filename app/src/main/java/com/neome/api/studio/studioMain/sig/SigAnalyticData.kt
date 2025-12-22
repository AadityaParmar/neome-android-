// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.sig

import com.neome.api.nucleus.base.Types.EnumAnalyticEventType
import com.neome.api.nucleus.base.sig.Sig

class SigAnalyticData : Sig() {
    val eventDataMap: Record<EnumAnalyticEventType, SigAnalyticEventData>
}
