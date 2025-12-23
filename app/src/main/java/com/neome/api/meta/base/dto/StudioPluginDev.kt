// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdVar

open class StudioPluginDev : StudioBase() {
    lateinit var lastUpdateTime: String
    var packageNameVarId: MetaIdVar? = null
    var pluginConfigFormId: MetaIdForm? = null
}
