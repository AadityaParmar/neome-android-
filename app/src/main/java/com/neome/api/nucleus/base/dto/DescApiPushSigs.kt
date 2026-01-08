// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.nucleus.base.dto

import com.neome.api.meta.base.Types.ServiceName

interface DescApiPushSigs
{
  val importMap: Map<String, String>
  val pushSigs: Map<String, ServiceName>
}