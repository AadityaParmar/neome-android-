// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.base.dto

import com.neome.api.meta.base.Types.PluginBundleId
import com.neome.api.meta.base.Types.PluginId
import java.util.Map

open class DtoPluginBundle {
    lateinit var pluginBundleId: PluginBundleId
    lateinit var pluginName: String
    lateinit var pluginVersionMap: Map<PluginId, DtoPlugin>
}
