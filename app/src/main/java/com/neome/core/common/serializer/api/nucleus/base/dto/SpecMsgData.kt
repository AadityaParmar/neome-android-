package com.neome.core.common.serializer.api.nucleus.base.dto

import com.neome.api.meta.base.Types.ServiceName
import com.neome.api.nucleus.base.dto.SpecMsg
import kotlinx.serialization.Serializable


@Serializable
data class SpecMsgData(
    override val module: String,
    override val paramMap: Map<String, String>? = null,
    override val serviceName: ServiceName
) : SpecMsg
