// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

open class StudioPluginResourceMap : StudioBase() {
    var dev: StudioPluginDev? = null
    var jar: StudioPluginJar? = null
    var rpc: StudioPluginRpc? = null
}
