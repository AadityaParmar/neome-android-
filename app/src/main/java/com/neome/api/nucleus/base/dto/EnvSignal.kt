// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.nucleus.base.dto

import com.neome.api.meta.base.Types.RequestId
import com.neome.api.meta.base.Types.ServiceName
import com.neome.api.meta.base.sig.ISig

open class EnvSignal<S : ISig> {
    var cookieRememberMe: Boolean? = null
    var cookieValue: String? = null
    var error: EnvError? = null
    var requestId: RequestId? = null
    var serverName: String? = null
    var serverTime: Number? = null
    var serviceName: ServiceName? = null
    var sig: S? = null
    var sigName: String? = null
}
