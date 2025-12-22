// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdPlugin
import com.neome.api.meta.base.Types.PluginApiId

class DefnStudioPickPluginFormId : DefnStudioPickFormId() {
    var pluginApiId: PluginApiId? = null
    var pluginId: MetaIdPlugin? = null
}
