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
import com.neome.core.common.serializer.api.nucleus.base.dto.DescApiCallData
import com.neome.core.common.serializer.api.nucleus.base.dto.DescApiTypeBasicData
import com.neome.core.common.serializer.api.nucleus.base.dto.DescApiTypeDtoData
import com.neome.core.common.serializer.api.nucleus.base.dto.DescApiTypeEnumData
import com.neome.core.common.serializer.api.nucleus.base.dto.DescApiTypeSetData
import com.neome.core.common.serializer.api.nucleus.base.dto.DescApiTypeSysIdData
import kotlinx.serialization.Serializable


@Serializable
data class DescApiServiceData(
    override val basic: Map<String, DescApiTypeBasicData>,
    override val consts: Map<String, String>,
    override val dto: Map<String, DescApiTypeDtoData>,
    override val enums: Map<String, DescApiTypeEnumData>,
    override val msg: Map<String, DescApiTypeDtoData>,
    override val rpc: DescApiCallData,
    override val serviceNames: List<ServiceName>? = null,
    override val sets: Map<String, DescApiTypeSetData>,
    override val sig: Map<String, DescApiTypeDtoData>,
    override val symbols: Map<String, String>,
    override val sysId: Map<String, DescApiTypeSysIdData>,
    override val sysIdPrefix: Map<String, String>,
    override val wsoc: DescApiCallData
) : DescApiService
