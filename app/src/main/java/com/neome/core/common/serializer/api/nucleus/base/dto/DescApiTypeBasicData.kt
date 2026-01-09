package com.neome.core.common.serializer.api.nucleus.base.dto

import com.neome.api.nucleus.base.dto.DescApiType
import com.neome.api.nucleus.base.dto.DescApiTypeBasic
import kotlinx.serialization.Serializable


@Serializable
data class DescApiTypeBasicData(
    override val importRef: String? = null,
    override val superCls: String? = null,
    override val value: String
) : DescApiTypeBasic
