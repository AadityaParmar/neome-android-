// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Types.MetaIdPlugin
import com.neome.api.meta.base.Types.PluginApiId
import com.neome.api.meta.base.Types.RequestId
import com.neome.api.meta.base.dto.EntUserIdTriple
import com.neome.api.meta.base.dto.FormValueRaw

class DtoPluginApiRequestPayload {
    var callerTriplet: EntUserIdTriple? = null
    val pluginApiId: PluginApiId
    val pluginId: MetaIdPlugin
    var pluginInputFormValue: FormValueRaw? = null
    val requestId: RequestId
    val responseActorPath: string
}
