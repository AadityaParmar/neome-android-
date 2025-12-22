// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdForm

class StudioPluginRpc : StudioBase() {
    val lastUpdateTime: string
    var pluginConfigFormId: MetaIdForm? = null
}
