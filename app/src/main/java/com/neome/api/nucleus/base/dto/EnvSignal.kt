// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.nucleus.base.dto

import com.neome.api.nucleus.base.dto.EnvError
import com.neome.api.meta.base.sig.ISig
import com.neome.api.meta.base.Types.RequestId
import com.neome.api.meta.base.Types.ServiceName

interface EnvSignal<S : ISig>
{
  val cookieRememberMe: Boolean?
  val cookieValue: String?
  val error: EnvError?
  val requestId: RequestId?
  val serverName: String?
  val serverTime: Long?
  val serviceName: ServiceName?
  val sig: S?
  val sigName: String?
}