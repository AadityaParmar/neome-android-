// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.EnumDefnPluginApiMethod
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.PluginApiId

open class StudioPluginApi : StudioBase() {
    lateinit var apiType: EnumDefnPluginApiMethod
    var baseURLVarId: StudioValueVarIdText? = null
    lateinit var creationDate: String
    var description: String? = null
    var guaranteedInvocation: Boolean? = null
    var headerParamMap: StudioMapOfArgBinder? = null
    var inputFormId: MetaIdForm? = null
    lateinit var metaId: PluginApiId
    var modules: StudioModuleSelection? = null
    lateinit var name: Symbol
    var outputFormId: MetaIdForm? = null
    var queryParamMap: StudioMapOfArgBinder? = null
    var requestBody: StudioPluginApiBody? = null
    var responseBody: StudioPluginApiBody? = null
}
