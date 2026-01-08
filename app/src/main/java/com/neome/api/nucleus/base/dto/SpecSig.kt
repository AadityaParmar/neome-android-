// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.nucleus.base.dto

import com.neome.api.meta.base.Types.ServiceName

interface SpecSig
{
  val module: String
  val serverPush: Boolean
  val serviceName: ServiceName
}