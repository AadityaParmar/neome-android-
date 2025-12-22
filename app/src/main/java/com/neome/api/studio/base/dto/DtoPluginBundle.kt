// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.base.dto

import com.neome.api.meta.base.Types.PluginBundleId
import com.neome.api.meta.base.Types.PluginId

class DtoPluginBundle {
    val pluginBundleId: PluginBundleId
    val pluginName: string
    val pluginVersionMap: Record<PluginId, DtoPlugin>
}
