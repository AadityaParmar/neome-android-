// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.PluginId

class StudioPluginMap : StudioBase() {
    val keys: PluginId[]
    val map: Record<PluginId, StudioPlugin>
}
