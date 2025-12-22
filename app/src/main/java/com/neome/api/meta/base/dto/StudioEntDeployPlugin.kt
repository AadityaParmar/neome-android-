// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.EnumDefnPluginResources
import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.api.meta.base.Types.MetaIdPlugin

class StudioEntDeployPlugin : StudioBase() {
    val metaId: MetaIdPlugin
    val name: Symbol
    var pluginConfigFormValueMap: Record<MetaIdComp, any>? = null
    var pluginType: EnumDefnPluginResources? = null
}
