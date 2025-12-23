// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdPlugin
import java.util.Map

open class StudioEntPluginMap : StudioBase() {
    lateinit var keys: Array<MetaIdPlugin>
    lateinit var map: Map<MetaIdPlugin, StudioEntPlugin>
}
