// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.nucleus.base.dto

import com.neome.api.meta.base.Types.RequestId
import com.neome.api.meta.base.Types.ServiceName
import com.neome.api.meta.base.sig.ISig

class EnvSignal<S : ISig> {
    var cookieRememberMe: boolean? = null
    var cookieValue: string? = null
    var error: EnvError? = null
    var requestId: RequestId? = null
    var serverName: string? = null
    var serverTime: number? = null
    var serviceName: ServiceName? = null
    var sig: S? = null
    var sigName: string? = null
}
