// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.agent.msg

import com.neome.api.meta.base.Types.RequestId
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.nucleus.base.dto.EnvError
import com.neome.api.nucleus.base.msg.Msg

class MsgPluginApiResponse : Msg() {
    var pluginError: EnvError? = null
    val requestId: RequestId
    var responseFormValue: FormValueRaw? = null
}
