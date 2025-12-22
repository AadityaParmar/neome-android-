// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.AdminId
import com.neome.api.meta.base.Types.MetaIdPlugin

class StudioEntDeployPluginMap : StudioBase() {
    val keys: MetaIdPlugin[]
    val map: Record<MetaIdPlugin, StudioEntDeployPlugin>
    var singletonPluginsAdminId: AdminId? = null
}
