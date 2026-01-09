package com.neome.core.common.serializer.api.nucleus.base.dto

import com.neome.api.nucleus.base.dto.DescApiType
import com.neome.api.nucleus.base.dto.DescApiTypeDto
import kotlinx.serialization.Serializable


@Serializable
data class DescApiTypeDtoData(
    override val dtoDir: String,
    override val fieldMapJava: Map<String, String>? = null,
    override val fieldMapTypeScript: Map<String, String>? = null,
    override val importMap: Map<String, String>? = null,
    override val superClass: String? = null
) : DescApiTypeDto
