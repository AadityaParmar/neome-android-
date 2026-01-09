package com.neome.core.common.serializer.api.nucleus.base.dto

import com.neome.api.nucleus.base.dto.DescApiType
import com.neome.api.nucleus.base.dto.DescApiTypeSysId
import kotlinx.serialization.Serializable


@Serializable
data class DescApiTypeSysIdData(
    override val importRef: String? = null,
    override val superClass: String,
    override val value: String
) : DescApiTypeSysId
