// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.nucleus.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.ServiceName

interface SpecMsg
{
  val module: String
  val paramMap: Map<String, String>?
  val serviceName: ServiceName
}