// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.sig

import com.neome.api.nucleus.base.Types.EnumAnalyticEventType
import java.util.Map
import com.neome.api.nucleus.base.sig.Sig
import com.neome.api.studio.studioMain.sig.SigAnalyticEventData

open class SigAnalyticData : Sig()
{
  lateinit var eventDataMap: Map<EnumAnalyticEventType, SigAnalyticEventData>
}