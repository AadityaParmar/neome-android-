// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.nucleus.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.ServiceName

open class DescApiPushSigs
{
  lateinit var importMap: Map<String, String>
  lateinit var pushSigs: Map<String, ServiceName>
}