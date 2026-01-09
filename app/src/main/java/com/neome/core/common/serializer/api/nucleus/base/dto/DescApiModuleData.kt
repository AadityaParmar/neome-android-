package com.neome.core.common.serializer.api.nucleus.base.dto

import com.neome.api.meta.base.Types.ServiceName
import com.neome.api.nucleus.base.dto.DescApiModule
import com.neome.api.nucleus.base.dto.DescApiService
import kotlinx.serialization.Serializable


@Serializable
data class DescApiModuleData(
    override val service: Map<ServiceName, DescApiService>
) : DescApiModule
