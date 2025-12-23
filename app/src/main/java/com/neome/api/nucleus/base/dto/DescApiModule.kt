// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.nucleus.base.dto

import com.neome.api.meta.base.Types.ServiceName
import java.util.Map

open class DescApiModule {
    lateinit var service: Map<ServiceName, DescApiService>
}
