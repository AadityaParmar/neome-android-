// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.nucleus.base.dto

import com.neome.api.meta.base.Types.ServiceName

class SpecMsg {
    val module: string
    var paramMap: Record<string, string>? = null
    val serviceName: ServiceName
}
