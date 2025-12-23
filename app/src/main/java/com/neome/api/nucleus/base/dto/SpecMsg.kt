// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.nucleus.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.ServiceName

open class SpecMsg
{
  lateinit var module: String
  var paramMap: Map<String, String>? = null
  lateinit var serviceName: ServiceName
}