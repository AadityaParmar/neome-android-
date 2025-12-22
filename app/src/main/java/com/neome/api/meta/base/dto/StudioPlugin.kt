// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.AdminId
import com.neome.api.meta.base.Types.EnumDefnPluginMode
import com.neome.api.meta.base.Types.PluginId

class StudioPlugin : StudioDeployUnit() {
    val apiMap: StudioPluginApiMap
    var createdBy: AdminId? = null
    var creationTime: string? = null
    val deploy: StudioPluginDeploy
    var deprecate: boolean? = null
    val details: StudioPluginDetails
    val formMap: StudioFormMap
    var lastUpdateBy: AdminId? = null
    var lastUpdateTime: string? = null
    val metaId: PluginId
    val mode: EnumDefnPluginMode
    val moduleMap: StudioModuleMap
    var resourceMap: StudioPluginResourceMap? = null
    var storeItemDetailMap: StudioStoreItemDetailMap? = null
    var trash: StudioPluginTrash? = null
    val varMap: StudioVarMap
    var version: string? = null
}
