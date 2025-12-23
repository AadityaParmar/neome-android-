// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.sig

import kotlin.properties.Delegates
import com.neome.api.nucleus.base.sig.Sig

open class SigAnalyticEventCount : Sig()
{
  var eventCount: Number by Delegates.notNull<Number>()
}