// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.PluginId
import java.util.Map

open class StudioPluginMap : StudioBase() {
    lateinit var keys: Array<PluginId>
    lateinit var map: Map<PluginId, StudioPlugin>
}
