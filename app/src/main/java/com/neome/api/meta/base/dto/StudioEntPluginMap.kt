// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdPlugin

class StudioEntPluginMap : StudioBase() {
    val keys: MetaIdPlugin[]
    val map: Record<MetaIdPlugin, StudioEntPlugin>
}
