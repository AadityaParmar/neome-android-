// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.PluginApiId
import java.util.Map

open class StudioPluginApiMap : StudioBase() {
    lateinit var keys: Array<PluginApiId>
    lateinit var map: Map<PluginApiId, StudioPluginApi>
    var pluginConfigFormId: MetaIdForm? = null
}
