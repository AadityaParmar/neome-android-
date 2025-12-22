// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.nucleus.base.dto

import com.neome.api.meta.base.Types.ServiceName

class DescApiService {
    val basic: Record<string, DescApiTypeBasic>
    val consts: Record<string, string>
    val dto: Record<string, DescApiTypeDto>
    val enums: Record<string, DescApiTypeEnum>
    val msg: Record<string, DescApiTypeDto>
    val rpc: DescApiCall
    var serviceNames: ServiceName[]? = null
    val sets: Record<string, DescApiTypeSet>
    val sig: Record<string, DescApiTypeDto>
    val symbols: Record<string, string>
    val sysId: Record<string, DescApiTypeSysId>
    val sysIdPrefix: Record<string, string>
    val wsoc: DescApiCall
}
