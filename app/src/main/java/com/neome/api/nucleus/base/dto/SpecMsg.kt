// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.nucleus.base.dto

import com.neome.api.meta.base.Types.ServiceName
import java.util.Map

open class SpecMsg {
    lateinit var module: String
    var paramMap: Map<String, String>? = null
    lateinit var serviceName: ServiceName
}
