// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.EnumDefnPluginApiMethod
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.PluginApiId

class StudioPluginApi : StudioBase() {
    val apiType: EnumDefnPluginApiMethod
    var baseURLVarId: StudioValueVarIdText? = null
    val creationDate: string
    var description: string? = null
    var guaranteedInvocation: boolean? = null
    var headerParamMap: StudioMapOfArgBinder? = null
    var inputFormId: MetaIdForm? = null
    val metaId: PluginApiId
    var modules: StudioModuleSelection? = null
    val name: Symbol
    var outputFormId: MetaIdForm? = null
    var queryParamMap: StudioMapOfArgBinder? = null
    var requestBody: StudioPluginApiBody? = null
    var responseBody: StudioPluginApiBody? = null
}
