// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.PluginApiId

class StudioPluginApiMap : StudioBase() {
    val keys: PluginApiId[]
    val map: Record<PluginApiId, StudioPluginApi>
    var pluginConfigFormId: MetaIdForm? = null
}
