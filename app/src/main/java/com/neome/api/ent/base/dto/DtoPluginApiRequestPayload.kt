// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Types.MetaIdPlugin
import com.neome.api.meta.base.Types.PluginApiId
import com.neome.api.meta.base.Types.RequestId
import com.neome.api.meta.base.dto.EntUserIdTriple
import com.neome.api.meta.base.dto.FormValueRaw

open class DtoPluginApiRequestPayload {
    var callerTriplet: EntUserIdTriple? = null
    lateinit var pluginApiId: PluginApiId
    lateinit var pluginId: MetaIdPlugin
    var pluginInputFormValue: FormValueRaw? = null
    lateinit var requestId: RequestId
    lateinit var responseActorPath: String
}
