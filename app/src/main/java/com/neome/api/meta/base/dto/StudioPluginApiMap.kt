// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.PluginApiId

interface StudioPluginApiMap : StudioBase {
    val keys: List<PluginApiId>
    val map: Map<PluginApiId, StudioPluginApi>
    val pluginConfigFormId: MetaIdForm?
}
