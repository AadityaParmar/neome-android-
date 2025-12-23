// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.sig

import com.neome.api.nucleus.base.sig.Sig

open class SigAnalyticEventData : Sig() {
    lateinit var endDate: String
    lateinit var eventCounts: Array<Number>
    lateinit var startDate: String
}
