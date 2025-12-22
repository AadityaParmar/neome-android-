// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.EnumDefnPluginApiMethod

class DtoPluginApiSpec {
    var input: any? = null
    val method: EnumDefnPluginApiMethod
    val name: Symbol
    var output: any? = null
    val url: string
}
