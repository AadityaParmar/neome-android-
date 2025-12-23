// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.nucleus.base.dto

import com.neome.api.meta.base.Types.ServiceName
import kotlin.properties.Delegates

open class SpecSig {
    lateinit var module: String
    var serverPush: Boolean by Delegates.notNull<Boolean>()
    lateinit var serviceName: ServiceName
}
