// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.AdminId
import com.neome.api.meta.base.Types.PluginBundleId

class StudioPluginBundleBase : StudioBase() {
    val createdBy: AdminId
    val creationTime: string
    var deployMap: StudioPluginMap? = null
    val pluginBundleId: PluginBundleId
    val updateBy: AdminId
    val updateTime: string
    val version: string
}
