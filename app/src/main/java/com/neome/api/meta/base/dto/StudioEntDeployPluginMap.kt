// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.AdminId
import com.neome.api.meta.base.Types.MetaIdPlugin

interface StudioEntDeployPluginMap : StudioBase {
    val keys: List<MetaIdPlugin>
    val map: Map<MetaIdPlugin, StudioEntDeployPlugin>
    val singletonPluginsAdminId: AdminId?
}
