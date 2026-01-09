package com.neome.core.common.serializer.api.nucleus.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.ServiceName
import com.neome.api.nucleus.base.dto.DescApiCall
import com.neome.api.nucleus.base.dto.DescApiService
import com.neome.api.nucleus.base.dto.DescApiTypeBasic
import com.neome.api.nucleus.base.dto.DescApiTypeDto
import com.neome.api.nucleus.base.dto.DescApiTypeEnum
import com.neome.api.nucleus.base.dto.DescApiTypeSet
import com.neome.api.nucleus.base.dto.DescApiTypeSysId
import kotlinx.serialization.Serializable


@Serializable
data class DescApiServiceData(
    override val basic: Map<String, DescApiTypeBasic>,
    override val consts: Map<String, String>,
    override val dto: Map<String, DescApiTypeDto>,
    override val enums: Map<String, DescApiTypeEnum>,
    override val msg: Map<String, DescApiTypeDto>,
    override val rpc: DescApiCall,
    override val serviceNames: Array<ServiceName>? = null,
    override val sets: Map<String, DescApiTypeSet>,
    override val sig: Map<String, DescApiTypeDto>,
    override val symbols: Map<String, String>,
    override val sysId: Map<String, DescApiTypeSysId>,
    override val sysIdPrefix: Map<String, String>,
    override val wsoc: DescApiCall
) : DescApiService
