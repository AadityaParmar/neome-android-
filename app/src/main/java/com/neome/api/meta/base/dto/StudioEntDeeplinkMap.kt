// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdDeeplink

class StudioEntDeeplinkMap : StudioBase() {
    val keys: MetaIdDeeplink[]
    val map: Record<MetaIdDeeplink, StudioEntDeeplink>
}
