// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdForm

open class StudioPluginRpc : StudioBase() {
    lateinit var lastUpdateTime: String
    var pluginConfigFormId: MetaIdForm? = null
}
