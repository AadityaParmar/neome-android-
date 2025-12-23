// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.nucleus.base.dto

import com.neome.api.meta.base.Types.ServiceName
import java.util.Map

open class DescApiService {
    lateinit var basic: Map<String, DescApiTypeBasic>
    lateinit var consts: Map<String, String>
    lateinit var dto: Map<String, DescApiTypeDto>
    lateinit var enums: Map<String, DescApiTypeEnum>
    lateinit var msg: Map<String, DescApiTypeDto>
    lateinit var rpc: DescApiCall
    var serviceNames: Array<ServiceName>? = null
    lateinit var sets: Map<String, DescApiTypeSet>
    lateinit var sig: Map<String, DescApiTypeDto>
    lateinit var symbols: Map<String, String>
    lateinit var sysId: Map<String, DescApiTypeSysId>
    lateinit var sysIdPrefix: Map<String, String>
    lateinit var wsoc: DescApiCall
}
