// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.sig

import com.neome.api.nucleus.base.sig.Sig

class SigAnalyticEventData : Sig() {
    val endDate: string
    val eventCounts: number[]
    val startDate: string
}
