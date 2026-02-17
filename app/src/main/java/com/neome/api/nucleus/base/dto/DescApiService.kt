// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.nucleus.base.dto

import com.neome.api.nucleus.base.dto.DescApiCall
import com.neome.api.nucleus.base.dto.DescApiTypeBasic
import com.neome.api.nucleus.base.dto.DescApiTypeDto
import com.neome.api.nucleus.base.dto.DescApiTypeEnum
import com.neome.api.nucleus.base.dto.DescApiTypeSet
import com.neome.api.nucleus.base.dto.DescApiTypeSysId
import com.neome.api.meta.base.Types.ServiceName

interface DescApiService
{
  val basic: Map<String, DescApiTypeBasic>
  val consts: Map<String, String>
  val dto: Map<String, DescApiTypeDto>
  val enums: Map<String, DescApiTypeEnum>
  val msg: Map<String, DescApiTypeDto>
  val rpc: DescApiCall
  val serviceNames: Set<ServiceName>?
  val sets: Map<String, DescApiTypeSet>
  val sig: Map<String, DescApiTypeDto>
  val symbols: Map<String, String>
  val sysId: Map<String, DescApiTypeSysId>
  val sysIdPrefix: Map<String, String>
  val wsoc: DescApiCall
}