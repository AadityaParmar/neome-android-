// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.EnumDefnPluginResources
import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.api.meta.base.Types.MetaIdPlugin
import java.util.Map

open class StudioEntDeployPlugin : StudioBase() {
    lateinit var metaId: MetaIdPlugin
    lateinit var name: Symbol
    var pluginConfigFormValueMap: Map<MetaIdComp, Any>? = null
    var pluginType: EnumDefnPluginResources? = null
}
