package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.Size
import kotlinx.serialization.Serializable


@Serializable
data class SizeData(
    override val h: Long? = null,
    override val w: Long? = null
) : Size
