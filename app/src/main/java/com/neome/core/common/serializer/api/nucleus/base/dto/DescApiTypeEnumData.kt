package com.neome.core.common.serializer.api.nucleus.base.dto

import com.neome.api.nucleus.base.dto.DescApiType
import com.neome.api.nucleus.base.dto.DescApiTypeEnum
import kotlinx.serialization.Serializable


@Serializable
data class DescApiTypeEnumData(
    override val valueSet: Array<String>
) : DescApiTypeEnum
