package com.neome.core.common.serializer.api.nucleus.base.dto

import com.neome.api.nucleus.base.dto.DescApiCall
import com.neome.api.nucleus.base.dto.SpecApi
import kotlinx.serialization.Serializable


@Serializable
data class DescApiCallData(
    override val call: Map<String, SpecApi>? = null,
    override val importMap: Map<String, String>? = null,
    override val pathSeg: String
) : DescApiCall
