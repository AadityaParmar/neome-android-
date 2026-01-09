package com.neome.core.common.serializer.api.nucleus.base.dto

import com.neome.api.meta.base.Types.ServiceName
import com.neome.api.nucleus.base.dto.DescApiPushSigs
import kotlinx.serialization.Serializable


@Serializable
data class DescApiPushSigsData(
    override val importMap: Map<String, String>,
    override val pushSigs: Map<String, ServiceName>
) : DescApiPushSigs
