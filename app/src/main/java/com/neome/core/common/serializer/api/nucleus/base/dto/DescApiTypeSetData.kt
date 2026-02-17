package com.neome.core.common.serializer.api.nucleus.base.dto

import com.neome.api.nucleus.base.dto.DescApiTypeSet
import kotlinx.serialization.Serializable


@Serializable
data class DescApiTypeSetData(
    override val fileName: String,
    override val setMap: Map<String, Set<String>>
) : DescApiTypeSet
