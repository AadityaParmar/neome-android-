// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.AdminId
import com.neome.api.meta.base.Types.PluginBundleId

open class StudioPluginBundleBase : StudioBase() {
    lateinit var createdBy: AdminId
    lateinit var creationTime: String
    var deployMap: StudioPluginMap? = null
    lateinit var pluginBundleId: PluginBundleId
    lateinit var updateBy: AdminId
    lateinit var updateTime: String
    lateinit var version: String
}
