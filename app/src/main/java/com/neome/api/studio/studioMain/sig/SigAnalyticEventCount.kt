// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.sig

import com.neome.api.nucleus.base.sig.Sig
import kotlin.properties.Delegates

open class SigAnalyticEventCount : Sig() {
    var eventCount: Number by Delegates.notNull<Number>()
}
