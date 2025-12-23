// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdDeeplink
import java.util.Map

open class StudioEntDeeplinkMap : StudioBase() {
    lateinit var keys: Array<MetaIdDeeplink>
    lateinit var map: Map<MetaIdDeeplink, StudioEntDeeplink>
}
