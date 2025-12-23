// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.nucleus.base.dto

import com.neome.api.nucleus.base.dto.DescApiService
import java.util.Map
import com.neome.api.meta.base.Types.ServiceName

open class DescApiModule
{
  lateinit var service: Map<ServiceName, DescApiService>
}