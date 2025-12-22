// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnPluginApiMethod
import com.neome.api.meta.base.Types.MetaIdPlugin
import com.neome.api.meta.base.Types.PluginApiId

class DefnStudioPickImportPluginApiId : DefnFieldEditable() {
    var excludePluginApiIdSet: PluginApiId[]? = null
    var filterApiMethodSet: EnumDefnPluginApiMethod[]? = null
    val metaIdPlugin: MetaIdPlugin
}
